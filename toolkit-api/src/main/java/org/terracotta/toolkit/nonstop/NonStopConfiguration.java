/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.nonstop.NonStopConfigurationFields.NonStopTimeoutBehavior;

public interface NonStopConfiguration {
  NonStopTimeoutBehavior getNonStopTimeoutBehavior();

  long getTimeoutMillis();
  
  boolean isEnabled();
}
