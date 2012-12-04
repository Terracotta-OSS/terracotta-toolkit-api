/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
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
  NonStopReadTimeoutBehavior getImmutableOpNonStopTimeoutBehavior();

  /**
   * @return Mutable Operations Non Stop Timeout Behavior associated with this {@link NonStopConfiguration}
   */
  NonStopWriteTimeoutBehavior getMutableOpNonStopTimeoutBehavior();

  /**
   * @return time out in millis. This is the time out after which toolkit will attempt to abort the on going operation.
   */
  long getTimeoutMillis();

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
