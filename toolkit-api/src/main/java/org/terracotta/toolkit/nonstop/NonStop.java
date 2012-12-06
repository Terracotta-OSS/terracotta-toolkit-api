/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.ToolkitFeature;

public interface NonStop extends ToolkitFeature {
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
   * get Registry for registering non stop configurations
   */
  NonStopConfigurationRegistry getNonStopConfigurationRegistry();
}
