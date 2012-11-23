/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import static org.terracotta.toolkit.ToolkitObjectType.CACHE;
import static org.terracotta.toolkit.ToolkitObjectType.STORE;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.ToolkitObjectType;
import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopTimeoutBehavior;
import org.terracotta.toolkit.store.ConfigurationImpl;

import java.util.EnumSet;

public class NonStopConfigurationBuilder {
  private static final EnumSet<ToolkitObjectType> SUPPORTED_TOOLKIT_TYPES           = EnumSet.of(STORE, CACHE);

  private NonStopTimeoutBehavior                  immutableOpNonStopTimeoutBehavior = NonStopConfigurationFields.DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR;
  private NonStopTimeoutBehavior                  mutableOpNonStopTimeoutBehavior   = NonStopConfigurationFields.DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR;
  private long                                    timeout                           = NonStopConfigurationFields.DEFAULT_TIMEOUT_MILLIS;
  private boolean                                 isEnabled                         = NonStopConfigurationFields.DEFAULT_NON_STOP_ENABLED;
  private boolean                                 immediateTimeout                  = NonStopConfigurationFields.DEFAULT_NON_STOP_IMMEDIATE_TIMEOUT_ENABLED;

  private ToolkitObjectType[]                     nonStopToolkitTypes               = SUPPORTED_TOOLKIT_TYPES
                                                                                        .toArray(new ToolkitObjectType[0]);
  private String                                  name                              = null;
  private String                                  method                            = null;

  public NonStopConfigurationBuilder nonStopTimeoutBehavior(NonStopTimeoutBehavior immutableOpBehavior,
                                                            NonStopTimeoutBehavior mutableOpBehavior) {
    if (mutableOpBehavior == NonStopTimeoutBehavior.LOCAL_READS) { throw new IllegalArgumentException(
                                                                                                      "LOCAL_READS is not supported for mutable operations"); }

    this.immutableOpNonStopTimeoutBehavior = immutableOpBehavior;
    this.mutableOpNonStopTimeoutBehavior = mutableOpBehavior;
    return this;
  }

  public NonStopConfigurationBuilder timeoutMillis(long timeoutParam) {
    this.timeout = timeoutParam;
    return this;
  }

  public NonStopConfigurationBuilder toolkitInstanceName(String nameParam) {
    if (nameParam == null) { throw new IllegalArgumentException("name cannot be null"); }
    this.name = nameParam;
    return this;
  }

  public NonStopConfigurationBuilder immediateTimeout(boolean enabled) {
    this.immediateTimeout = enabled;
    return this;
  }

  public NonStopConfigurationBuilder methodName(String methodParam) {
    if (methodParam == null) { throw new IllegalArgumentException("methodRegex cannot be null"); }
    this.method = methodParam;
    return this;
  }

  public NonStopConfigurationBuilder nonStopToolkitType(ToolkitObjectType... nonStopToolkitTypesParam) {
    for (ToolkitObjectType nonStopToolkitTypeParam : nonStopToolkitTypesParam) {
      if (!SUPPORTED_TOOLKIT_TYPES.contains(nonStopToolkitTypeParam)) { throw new UnsupportedOperationException(
                                                                                                                nonStopToolkitTypeParam
                                                                                                                    .name()
                                                                                                                    + " is not yet supported as a non stop data structure"); }
    }

    this.nonStopToolkitTypes = nonStopToolkitTypesParam;
    return this;
  }

  public NonStopConfigurationBuilder enable(boolean isEnabledParam) {
    this.isEnabled = isEnabledParam;
    return this;
  }

  public void apply(Toolkit toolkit) {
    NonStopConfigurationRegistry nonStopToolkitRegistry = toolkit.getNonStopToolkitRegistry();
    NonStopConfiguration config = new NonStopToolkitConfigImpl(isEnabled, timeout, immutableOpNonStopTimeoutBehavior,
                                                               mutableOpNonStopTimeoutBehavior,
                                                               immediateTimeout);

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

  private static class NonStopToolkitConfigImpl extends ConfigurationImpl implements NonStopConfiguration {

    NonStopToolkitConfigImpl(boolean isEnabled, long timeout, NonStopTimeoutBehavior immutableOpBehavior,
                             NonStopTimeoutBehavior mutableOpBehavior,
                             boolean immediateTimeout) {
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_TIMEOUT_MILLIS, timeout);
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_READ_TIMEOUT_BEHAVIOR, immutableOpBehavior.name());
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_WRITE_TIMEOUT_BEHAVIOR, mutableOpBehavior.name());
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_ENABLED, isEnabled);
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_IMMEDIATE_TIMEOUT_ENABLED, immediateTimeout);
    }

    @Override
    public NonStopTimeoutBehavior getImmutableOpNonStopTimeoutBehavior() {
      String mode = getString(NonStopConfigurationFields.NON_STOP_READ_TIMEOUT_BEHAVIOR);
      return NonStopTimeoutBehavior.valueOf(mode);
    }

    @Override
    public NonStopTimeoutBehavior getMutableOpNonStopTimeoutBehavior() {
      String mode = getString(NonStopConfigurationFields.NON_STOP_WRITE_TIMEOUT_BEHAVIOR);
      return NonStopTimeoutBehavior.valueOf(mode);
    }

    @Override
    public long getTimeoutMillis() {
      return getLong(NonStopConfigurationFields.NON_STOP_TIMEOUT_MILLIS);
    }

    @Override
    public boolean isEnabled() {
      return getBoolean(NonStopConfigurationFields.NON_STOP_ENABLED);
    }

    @Override
    public boolean isImmediateTimeoutEnabled() {
      return getBoolean(NonStopConfigurationFields.NON_STOP_IMMEDIATE_TIMEOUT_ENABLED);
    }

  }
}
