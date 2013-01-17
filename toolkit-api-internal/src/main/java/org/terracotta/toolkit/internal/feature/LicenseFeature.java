/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.feature;

import org.terracotta.toolkit.ToolkitFeature;

/**
 * Feature that can be used to check if certain licenses are enabled or not
 */
public interface LicenseFeature extends ToolkitFeature {

  /**
   * Returns true if the license specified by <code>licenseName</code> is enabled, otherwise false
   * 
   * @return true if the license specified by <code>licenseName</code> is enabled, otherwise false
   */
  boolean isLicenseEnabled(String licenseName);

}
