/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.ToolkitObjectType;

public interface NonStopConfigRegistry {
  /**
   * Register methods
   */
  void registerForType(NonStopConfig config, ToolkitObjectType... types);

  void registerForInstance(NonStopConfig config, String toolkitTypeName, ToolkitObjectType... type);

  void registerForTypeMethod(NonStopConfig config, String methodName, ToolkitObjectType... type);

  void registerForInstanceMethod(NonStopConfig config, String methodName, String toolkitTypeName,
                                 ToolkitObjectType... type);

  /**
   * Get methods
   */
  NonStopConfig getConfigForType(ToolkitObjectType type);

  NonStopConfig getConfigForInstance(String toolkitTypeName, ToolkitObjectType type);

  NonStopConfig getConfigForTypeMethod(String methodName, ToolkitObjectType type);

  NonStopConfig getConfigForInstanceMethod(String methodName, String toolkitTypeName, ToolkitObjectType type);

  /**
   * De-register methods
   */
  NonStopConfig deregisterForType(ToolkitObjectType type);

  NonStopConfig deregisterForInstance(String toolkitTypeName, ToolkitObjectType type);

  NonStopConfig deregisterForTypeMethod(String methodName, ToolkitObjectType type);

  NonStopConfig deregisterForInstanceMethod(String methodName, String toolkitTypeName, ToolkitObjectType type);
}
