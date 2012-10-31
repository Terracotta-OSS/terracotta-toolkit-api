/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.nonstop.NonStopConfigFields.NonStopTimeoutBehavior;

public interface NonStopConfig {
  NonStopTimeoutBehavior getNonStopTimeoutBehavior();

  long getTimeout();
}
