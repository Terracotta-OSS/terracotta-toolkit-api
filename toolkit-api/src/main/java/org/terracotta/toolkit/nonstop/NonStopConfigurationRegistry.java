/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.ToolkitObjectType;

public interface NonStopConfigurationRegistry {
  /**
   * Register methods
   */
  void registerForType(NonStopConfiguration config, ToolkitObjectType... types);

  void registerForInstance(NonStopConfiguration config, String toolkitTypeName, ToolkitObjectType... type);

  void registerForTypeMethod(NonStopConfiguration config, String methodName, ToolkitObjectType... type);

  void registerForInstanceMethod(NonStopConfiguration config, String methodName, String toolkitTypeName,
                                 ToolkitObjectType... type);

  /**
   * Get methods
   */
  NonStopConfiguration getConfigForType(ToolkitObjectType type);

  NonStopConfiguration getConfigForInstance(String toolkitTypeName, ToolkitObjectType type);

  NonStopConfiguration getConfigForTypeMethod(String methodName, ToolkitObjectType type);

  NonStopConfiguration getConfigForInstanceMethod(String methodName, String toolkitTypeName, ToolkitObjectType type);

  /**
   * De-register methods
   */
  NonStopConfiguration deregisterForType(ToolkitObjectType type);

  NonStopConfiguration deregisterForInstance(String toolkitTypeName, ToolkitObjectType type);

  NonStopConfiguration deregisterForTypeMethod(String methodName, ToolkitObjectType type);

  NonStopConfiguration deregisterForInstanceMethod(String methodName, String toolkitTypeName, ToolkitObjectType type);
}
