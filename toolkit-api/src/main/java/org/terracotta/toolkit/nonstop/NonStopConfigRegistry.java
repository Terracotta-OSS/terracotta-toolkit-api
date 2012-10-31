/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.nonstop.NonStopConfigFields.NonStopToolkitType;

public interface NonStopConfigRegistry {
  /**
   * Register methods
   */
  void registerForType(NonStopConfig config, NonStopToolkitType... types);

  void registerForInstance(NonStopConfig config, String toolkitTypeName, NonStopToolkitType... type);

  void registerForTypeMethod(NonStopConfig config, String methodName, NonStopToolkitType... type);

  void registerForInstanceMethod(NonStopConfig config, String methodName, String toolkitTypeName,
                                 NonStopToolkitType... type);

  /**
   * Get methods
   */
  NonStopConfig getConfigForType(NonStopToolkitType type);

  NonStopConfig getConfigForInstance(String toolkitTypeName, NonStopToolkitType type);

  NonStopConfig getConfigForTypeMethod(String methodName, NonStopToolkitType type);

  NonStopConfig getConfigForInstanceMethod(String methodName, String toolkitTypeName, NonStopToolkitType type);

  /**
   * De-register methods
   */
  NonStopConfig deregisterForType(NonStopToolkitType type);

  NonStopConfig deregisterForInstance(String toolkitTypeName, NonStopToolkitType type);

  NonStopConfig deregisterForTypeMethod(String methodName, NonStopToolkitType type);

  NonStopConfig deregisterForInstanceMethod(String methodName, String toolkitTypeName, NonStopToolkitType type);
}
