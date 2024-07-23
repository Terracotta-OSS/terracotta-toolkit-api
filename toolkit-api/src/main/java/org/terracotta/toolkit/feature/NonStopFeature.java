/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.feature;

import org.terracotta.toolkit.ToolkitFeature;
import org.terracotta.toolkit.nonstop.NonStopConfiguration;
import org.terracotta.toolkit.nonstop.NonStopConfigurationRegistry;

public interface NonStopFeature extends ToolkitFeature {
  /**
   * Start non stop operations
   */
  void start(NonStopConfiguration nonStopConfig);

  /**
   * End the non stop operations.<br>
   * Within the boundary of start and stop the operations should come back.
   */
  void finish();

  /**
   * returns true If a nonstop operation was started and has timed out.
   */
  boolean isTimedOut();

  /**
   * get Registry for registering non stop configurations
   */
  NonStopConfigurationRegistry getNonStopConfigurationRegistry();
}
