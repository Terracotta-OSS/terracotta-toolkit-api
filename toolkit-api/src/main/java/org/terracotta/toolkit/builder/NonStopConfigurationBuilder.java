/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.toolkit.builder;

import org.terracotta.toolkit.nonstop.NonStopConfiguration;
import org.terracotta.toolkit.nonstop.NonStopConfigurationFields;
import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopReadTimeoutBehavior;
import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopWriteTimeoutBehavior;

public class NonStopConfigurationBuilder {
  private NonStopReadTimeoutBehavior  immutableOpNonStopTimeoutBehavior = NonStopConfigurationFields.DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR;
  private NonStopWriteTimeoutBehavior mutableOpNonStopTimeoutBehavior   = NonStopConfigurationFields.DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR;
  private long                        timeout                           = NonStopConfigurationFields.DEFAULT_TIMEOUT_MILLIS;
  private long                        searchTimeout                     = -1;
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
    if (timeoutParam < 0) { throw new IllegalArgumentException("timeout cannot be less than 0"); }

    this.timeout = timeoutParam;
    return this;
  }

  public NonStopConfigurationBuilder searchTimeoutMillis(long searchTimeoutParam) {
    if (searchTimeoutParam < 0) { throw new IllegalArgumentException("default search timeout cannot be less than 0"); }

    this.searchTimeout = searchTimeoutParam;
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
    return new NonStopToolkitConfigImpl(isEnabled, timeout, searchTimeout <= 0 ? timeout : searchTimeout,
                                        immutableOpNonStopTimeoutBehavior, mutableOpNonStopTimeoutBehavior,
                                        immediateTimeout);
  }

  private static class NonStopToolkitConfigImpl extends ConfigurationImpl implements NonStopConfiguration {

    NonStopToolkitConfigImpl(boolean isEnabled, long timeout, long searchTimeout,
                             NonStopReadTimeoutBehavior immutableOpBehavior,
                             NonStopWriteTimeoutBehavior mutableOpBehavior, boolean immediateTimeout) {
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_TIMEOUT_MILLIS, timeout);
      internalSetConfigMapping(NonStopConfigurationFields.NON_STOP_SEARCH_TIMEOUT_MILLIS, searchTimeout);
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
    public long getSearchTimeoutMillis() {
      return getLong(NonStopConfigurationFields.NON_STOP_SEARCH_TIMEOUT_MILLIS);
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
