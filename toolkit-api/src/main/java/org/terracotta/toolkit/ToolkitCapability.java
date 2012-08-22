/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

/**
 * Toolkit capability that may or may not be present at runtime.
 */
public enum ToolkitCapability {
  /**
   * Search capability
   */
  SEARCH,
  /**
   * Offheap capability
   */
  OFFHEAP
}
