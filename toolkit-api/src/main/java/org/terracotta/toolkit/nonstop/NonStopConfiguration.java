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
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopReadTimeoutBehavior;
import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopWriteTimeoutBehavior;

/**
 * Configuration for using non stop
 */
public interface NonStopConfiguration {
  /**
   * @return Immutable Operations Non Stop Timeout Behavior associated with this {@link NonStopConfiguration}
   */
  NonStopReadTimeoutBehavior getReadOpNonStopTimeoutBehavior();

  /**
   * @return Mutable Operations Non Stop Timeout Behavior associated with this {@link NonStopConfiguration}
   */
  NonStopWriteTimeoutBehavior getWriteOpNonStopTimeoutBehavior();

  /**
   * @return time out in millis. This is the time out after which toolkit will attempt to abort the on going operation.
   */
  long getTimeoutMillis();


  /**
   * @return search timeout in millis. This is the time out after which toolkit will attempt to abort the on going search operation.
   */
  long getSearchTimeoutMillis();


  /**
   * @return if the non stop is enabled for this {@link NonStopConfiguration}
   */
  boolean isEnabled();

  /**
   * @return if toolkit disconnects with one the mirror groups, then the subsequent calls to the Toolkit will timeout
   *         immediately unless the toolkit connects with all the mirror groups again.
   */
  boolean isImmediateTimeoutEnabled();
}
