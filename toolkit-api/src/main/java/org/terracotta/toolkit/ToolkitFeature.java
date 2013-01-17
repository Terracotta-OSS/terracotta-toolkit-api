/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

/**
 * A toolkit feature. Implementations can opt to support extra features, and all features extends from this interface.
 * 
 * @see ToolkitFeatureType
 * @see Toolkit#getFeature(ToolkitFeatureType)
 */
public interface ToolkitFeature {

  /**
   * Returns true if the feature is enabled, otherwise false
   * 
   * @return true if the feature is enabled, otherwise false
   */
  boolean isEnabled();
}
