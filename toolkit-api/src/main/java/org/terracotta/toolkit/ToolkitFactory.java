/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit;

import org.terracotta.toolkit.api.ToolkitFactoryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;

/**
 * A static factory class used for creating {@link Toolkit} instances.
 * <br>
 * The actual instance of Toolkit created depends on the runtime environment and the configuration. The toolkitURI is
 * used to choose which implementation of Toolkit to instantiate. <br>
 * For example, for creating Terracotta clustered toolkit, use:
 * 
 * <pre>
 * Toolkit toolkit = ToolkitFactory.createToolkit(&quot;toolkit:terracotta://server:tsa-port&quot;);
 * </pre>
 * 
 * where server is the host-name/ip of the Terracotta Server and port is the port number where Terracotta Server Array
 * is running.
 * 
 * @author Abhishek Sanoujam
 */
public final class ToolkitFactory {

  private static final String TOOLKIT_URI_DELIM  = ":";
  private static final String TOOLKIT_URI_PREFIX = "toolkit" + TOOLKIT_URI_DELIM;

  /**
   * Same as calling ToolkitFactory.createToolkit(toolkitURI, null)}.
   * <p>
   * The created toolkit instance depends on the actual value of the {@code toolkitURI}<br>
   * For example, for creating Terracotta clustered toolkit, use:
   * 
   * <pre>
   * Toolkit toolkit = ToolkitFactory.createToolkit(&quot;toolkit:terracotta://server:tsa-port&quot;);
   * </pre>
   * 
   * where server is the host-name/ip of the Terracotta Server and port is the port number where Terracotta Server Array
   * is running.
   * 
   * @param toolkitURI the toolkit URI of the form <code>toolkit:<em>type:subname</em></code>
   * @return the toolkit instance
   * @throws ToolkitInstantiationException if unable to create the toolkit instance
   * @throws InvalidToolkitConfigException if unable to create the toolkit because of invalid configuration
   * @throws IllegalArgumentException if toolkitURI is not of the form <code>toolkit:<em>type:subname</em></code>
   * @see ToolkitFactory#createToolkit(String, Properties)
   */
  public static Toolkit createToolkit(String toolkitURI) throws ToolkitInstantiationException,
      InvalidToolkitConfigException, IllegalArgumentException {
    return createToolkit(toolkitURI, null);
  }

  /**
   * Creates an instance of Toolkit depending on the {@code toolkitURI}.
   * <br>
   * The toolkitURI is in the form of <code>toolkit:<em>type:subname</em></code><br>
   * The actual values of <em>type:subname</em> depends on the particular implementation of the Toolkit. <br>
   * For example, for creating Terracotta clustered toolkit, use:
   * 
   * <pre>
   * Toolkit toolkit = ToolkitFactory.createToolkit(&quot;toolkit:terracotta://server:tsa-port&quot;);
   * </pre>
   * 
   * where server is the host-name/ip of the Terracotta Server and port is the port number where Terracotta Server Array
   * is running.
   * 
   * @param toolkitURI the toolkit URI of the form <code>toolkit:<em>type:subname</em></code>
   * @param properties Implementation specific properties used for configuring the instantiated Toolkit. Depends on the
   *        Toolkit implementation how the properties is used. Can be null.
   * @return the toolkit instance
   * @throws ToolkitInstantiationException if unable to create the toolkit instance
   * @throws InvalidToolkitConfigException if unable to create the toolkit because of invalid configuration
   * @throws IllegalArgumentException if toolkitURI is not of the form <code>toolkit:<em>type:subname</em></code>
   */
  public static Toolkit createToolkit(String toolkitURI, Properties properties) throws ToolkitInstantiationException,
      InvalidToolkitConfigException, IllegalArgumentException {
    return create(toolkitURI, properties);
  }

  private static Toolkit create(String toolkitURI, Properties properties) throws ToolkitInstantiationException {
    ToolkitTypeSubNameTuple typeSubName = ToolkitTypeSubNameTuple.parseToolkitURI(toolkitURI);
    // check for multiple toolkit implementations
    List<ToolkitFactoryService> serviceList = new ArrayList<ToolkitFactoryService>();
    for (ToolkitFactoryService toolkitFactoryService : ToolkitFactoryServiceLookup.getToolkitFactoryServices()) {
      if (toolkitFactoryService.canHandleToolkitType(typeSubName.type, typeSubName.subName)) {
        serviceList.add(toolkitFactoryService);
      }
    }
    if (serviceList.size() == 0) {
      throw new ToolkitInstantiationException("No Toolkit implementation found in classpath for toolkitURI: "
                                              + toolkitURI);
    } else if (serviceList.size() == 1) {
      return serviceList.get(0).createToolkit(typeSubName.type, typeSubName.subName, properties);
    } else {
      StringBuilder sb = new StringBuilder();
      for (ToolkitFactoryService service : serviceList) {
        sb.append(service.getClass().getName());
        sb.append(", ");
      }
      throw new ToolkitInstantiationException("Multiple Toolkit implementation found in classpath for toolkitURI: "
                                              + toolkitURI + " Services : " + sb.toString());
    }
  }

  private static class ToolkitTypeSubNameTuple {
    private final String type;
    private final String subName;

    private ToolkitTypeSubNameTuple(String type, String subName) {
      this.type = type;
      this.subName = subName;
    }

    private static ToolkitTypeSubNameTuple parseToolkitURI(String toolkitURI) {
      if (toolkitURI == null || toolkitURI.trim().equals("")) {
        //
        throw new IllegalArgumentException("toolkitURI cannot be null or blank");
      }
      if (!toolkitURI.startsWith(TOOLKIT_URI_PREFIX)) {
        //
        throw new IllegalArgumentException("toolkitURI should start with '" + TOOLKIT_URI_PREFIX + "', toolkitURI='"
                                           + toolkitURI + "'");
      }
      String[] tokens = toolkitURI.split(":", 3);
      // there should be at least 3 tokens - 'toolkit' and 'type' and 'subname'. subname can be empty though
      if (tokens.length != 3) { throw new IllegalArgumentException(
                                                                   "toolkitURI should be in the form \"toolkit:type:subName\", toolkitURI='"
                                                                       + toolkitURI + "'"); }
      return new ToolkitTypeSubNameTuple(tokens[1], tokens[2]);
    }

  }

  private static class ToolkitFactoryServiceLookup {
    private static Iterable<ToolkitFactoryService> getToolkitFactoryServices() {
      return new Iterable<ToolkitFactoryService>() {
        @Override
        public Iterator<ToolkitFactoryService> iterator() {
          return ServiceLoader.load(ToolkitFactoryService.class, ToolkitFactoryServiceLookup.class.getClassLoader())
              .iterator();
        }
      };
    }
  }
}
