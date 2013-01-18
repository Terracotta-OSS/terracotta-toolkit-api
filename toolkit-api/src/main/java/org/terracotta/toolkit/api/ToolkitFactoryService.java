/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.api;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.ToolkitFactory;
import org.terracotta.toolkit.ToolkitInstantiationException;
import org.terracotta.toolkit.tck.TCKStrict;

import java.util.Properties;

/**
 * Service for creating {@link Toolkit} instances. This interface is implemented by toolkit implementations that want to
 * handle specific 'toolkitUrl's and provide their own toolkit implementation.
 * <p>
 * At runtime, the {@link ToolkitFactory} finds all implementations of this interface and chooses the first one that can
 * handle the given toolkitUrl. Implementations should return true for
 * {@link ToolkitFactoryService#canHandleToolkitType(String, String)} given the toolkit type and subName it can handle.
 * Implementors can deploy their implementation by deploying a jar containing the implementation in the classpath. The
 * jar should also contain a file "META-INF/services/org.terracotta.toolkit.api.ToolkitFactoryService" that contains the
 * fully-qualified classname of this service implementation in a single line.
 * 
 * @author Abhishek Sanoujam
 */
@TCKStrict
public interface ToolkitFactoryService {

  /**
   * Returns true if this implementation can handle toolkit types specified by 'type' and 'subName'. Otherwise returns
   * false.
   * 
   * @param type the type of the toolkit
   * @param subName subName for the toolkit
   * @return true if implementation can handle the given toolkit 'type' and 'subName', otherwise false
   * @see ToolkitFactory#createToolkit(String)
   * @see ToolkitFactory#createToolkit(String, Properties)
   */
  boolean canHandleToolkitType(String type, String subName);

  /**
   * Creates a Toolkit instance for the given type, subName and using the properties passed in. Implementations should
   * throw {@link ToolkitInstantiationException} if it cannot handle the toolkit type or if it cannot create the toolkit
   * due to wrong/invalid configuration.
   * 
   * @param type the type of the toolkit
   * @param subName subName for the toolkit
   * @param properties contains user configured properties. Can be null.
   * @return a toolkit instance
   * @throws ToolkitInstantiationException if the type cannot be handled or if there is any error
   * @see ToolkitFactory#createToolkit(String)
   * @see ToolkitFactory#createToolkit(String, Properties)
   */
  Toolkit createToolkit(String type, String subName, Properties properties) throws ToolkitInstantiationException;
}
