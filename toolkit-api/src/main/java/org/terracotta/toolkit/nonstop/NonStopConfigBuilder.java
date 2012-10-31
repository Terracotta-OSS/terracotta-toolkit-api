/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import static org.terracotta.toolkit.nonstop.NonStopConfigFields.NonStopToolkitType.CACHE;
import static org.terracotta.toolkit.nonstop.NonStopConfigFields.NonStopToolkitType.STORE;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.nonstop.NonStopConfigFields.NonStopTimeoutBehavior;
import org.terracotta.toolkit.nonstop.NonStopConfigFields.NonStopToolkitType;
import org.terracotta.toolkit.store.ConfigurationImpl;

import java.util.EnumSet;

public class NonStopConfigBuilder {
  private static final EnumSet<NonStopToolkitType> SUPPORTED_TOOLKIT_TYPES = EnumSet.of(STORE, CACHE);

  private NonStopTimeoutBehavior                   nonStopTimeoutBehavior  = NonStopConfigFields.DEFAULT_NON_STOP_TIMEOUT_BEHAVIOR;
  private long                                     timeout                 = NonStopConfigFields.DEFAULT_TIMEOUT_MILLIS;
  private NonStopToolkitType[]                     nonStopToolkitTypes     = SUPPORTED_TOOLKIT_TYPES
                                                                               .toArray(new NonStopToolkitType[0]);
  private String                                   name                    = null;
  private String                                   method                  = null;

  public NonStopConfigBuilder nonStopTimeoutBehavior(NonStopTimeoutBehavior nonStopTimeoutBehaviorParam) {
    this.nonStopTimeoutBehavior = nonStopTimeoutBehaviorParam;
    return this;
  }

  public NonStopConfigBuilder timeoutMillis(long timeoutParam) {
    this.timeout = timeoutParam;
    return this;
  }

  public NonStopConfigBuilder nonStopToolkitTypeName(String nameParam) {
    if (nameParam == null) { throw new IllegalArgumentException("name cannot be null"); }
    this.name = nameParam;
    return this;
  }

  public NonStopConfigBuilder nonStopToolkitTypeMethodName(String methodParam) {
    if (methodParam == null) { throw new IllegalArgumentException("methodRegex cannot be null"); }
    this.method = methodParam;
    return this;
  }

  public NonStopConfigBuilder nonStopToolkitType(NonStopToolkitType... nonStopToolkitTypesParam) {
    for (NonStopToolkitType nonStopToolkitTypeParam : nonStopToolkitTypesParam) {
      if (!SUPPORTED_TOOLKIT_TYPES.contains(nonStopToolkitTypeParam)) { throw new UnsupportedOperationException(
                                                                                                                nonStopToolkitTypeParam
                                                                                                                    .name()
                                                                                                                    + " is not yet supported as a non stop data structure"); }
    }

    this.nonStopToolkitTypes = nonStopToolkitTypesParam;
    return this;
  }

  public void apply(Toolkit toolkit) {
    NonStopConfigRegistry nonStopToolkitRegistry = toolkit.getNonStopToolkitRegistry();
    NonStopConfig config = new NonStopToolkitConfigImpl(timeout, nonStopTimeoutBehavior);

    if (name == null && method == null) {
      nonStopToolkitRegistry.registerForType(config, nonStopToolkitTypes);
    } else if (name != null && method == null) {
      nonStopToolkitRegistry.registerForInstance(config, name, nonStopToolkitTypes);
    } else if (name == null && method != null) {
      // TODO: verify that the method name exists for the ToolkitTypes
      nonStopToolkitRegistry.registerForTypeMethod(config, method, nonStopToolkitTypes);
    } else {
      // TODO: verify that the method name exists for the ToolkitTypes
      nonStopToolkitRegistry.registerForInstanceMethod(config, method, name, nonStopToolkitTypes);
    }
  }

  private static class NonStopToolkitConfigImpl extends ConfigurationImpl implements NonStopConfig {

    NonStopToolkitConfigImpl(long timeout, NonStopTimeoutBehavior nonStopTimeoutBehavior) {
      internalSetConfigMapping(NonStopConfigFields.NON_STOP_TIMEOUT_MILLIS, timeout);
      internalSetConfigMapping(NonStopConfigFields.NON_STOP_TIMEOUT_BEHAVIOR, nonStopTimeoutBehavior.name());
    }

    @Override
    public NonStopTimeoutBehavior getNonStopTimeoutBehavior() {
      String mode = getString(NonStopConfigFields.NON_STOP_TIMEOUT_BEHAVIOR);
      return NonStopTimeoutBehavior.valueOf(mode);
    }

    @Override
    public long getTimeout() {
      return getLong(NonStopConfigFields.NON_STOP_TIMEOUT_MILLIS);
    }

  }
}
