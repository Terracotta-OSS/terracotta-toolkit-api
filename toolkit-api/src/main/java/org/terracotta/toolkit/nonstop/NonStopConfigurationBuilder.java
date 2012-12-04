/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopReadTimeoutBehavior;
import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopWriteTimeoutBehavior;
import org.terracotta.toolkit.store.ConfigurationImpl;

public class NonStopConfigurationBuilder {
  private NonStopReadTimeoutBehavior  immutableOpNonStopTimeoutBehavior = NonStopConfigurationFields.DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR;
  private NonStopWriteTimeoutBehavior mutableOpNonStopTimeoutBehavior   = NonStopConfigurationFields.DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR;
  private long                        timeout                           = NonStopConfigurationFields.DEFAULT_TIMEOUT_MILLIS;
  private boolean                     isEnabled                         = NonStopConfigurationFields.DEFAULT_NON_STOP_ENABLED;
  private boolean                     immediateTimeout                  = NonStopConfigurationFields.DEFAULT_NON_STOP_IMMEDIATE_TIMEOUT_ENABLED;

  public NonStopConfigurationBuilder nonStopReadTimeoutBehavior(NonStopReadTimeoutBehavior immutableOpBehavior) {
    this.immutableOpNonStopTimeoutBehavior = immutableOpBehavior;
    return this;
  }

  public NonStopConfigurationBuilder nonStopWriteTimeoutBehavior(NonStopWriteTimeoutBehavior mutableOpBehavior) {
    this.mutableOpNonStopTimeoutBehavior = mutableOpBehavior;
    return this;
  }

  public NonStopConfigurationBuilder timeoutMillis(long timeoutParam) {
    this.timeout = timeoutParam;
    return this;
  }

  public NonStopConfigurationBuilder immediateTimeout(boolean enabled) {
    this.immediateTimeout = enabled;
    return this;
  }


  public NonStopConfigurationBuilder enable(boolean isEnabledParam) {
    this.isEnabled = isEnabledParam;
    return this;
  }

  public NonStopConfiguration build() {
    return new NonStopToolkitConfigImpl(isEnabled, timeout, immutableOpNonStopTimeoutBehavior,
                                                               mutableOpNonStopTimeoutBehavior, immediateTimeout);
  }

  private static class NonStopToolkitConfigImpl extends ConfigurationImpl implements NonStopConfiguration {

    NonStopToolkitConfigImpl(boolean isEnabled, long timeout, NonStopReadTimeoutBehavior immutableOpBehavior,
                             NonStopWriteTimeoutBehavior mutableOpBehavior, boolean immediateTimeout) {
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_TIMEOUT_MILLIS, timeout);
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_READ_OP_TIMEOUT_BEHAVIOR, immutableOpBehavior.name());
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_WRITE_OP_TIMEOUT_BEHAVIOR, mutableOpBehavior.name());
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_ENABLED, isEnabled);
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_IMMEDIATE_TIMEOUT_ENABLED, immediateTimeout);
    }

    @Override
    public NonStopReadTimeoutBehavior getReadOpNonStopTimeoutBehavior() {
      String mode = getString(NonStopConfigurationFields.NON_STOP_READ_OP_TIMEOUT_BEHAVIOR);
      return NonStopReadTimeoutBehavior.valueOf(mode);
    }

    @Override
    public NonStopWriteTimeoutBehavior getWriteOpNonStopTimeoutBehavior() {
      String mode = getString(NonStopConfigurationFields.NON_STOP_WRITE_OP_TIMEOUT_BEHAVIOR);
      return NonStopWriteTimeoutBehavior.valueOf(mode);
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
