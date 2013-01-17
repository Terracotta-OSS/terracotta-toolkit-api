/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

import org.terracotta.toolkit.internal.feature.LicenseFeature;

import java.util.ArrayList;
import java.util.List;

public final class ToolkitFeatureTypeInternal<T extends ToolkitFeature> {

  private static final List<ToolkitFeatureTypeInternal> features = new ArrayList<ToolkitFeatureTypeInternal>();

  private static <F extends ToolkitFeature> ToolkitFeatureTypeInternal<F> define(Class<F> clazz) {
    ToolkitFeatureTypeInternal type = new ToolkitFeatureTypeInternal(clazz);
    if (features.contains(type)) {
      //
      throw new AssertionError("Cannot define multiple times for same feature interface - " + clazz.getName());
    }
    features.add(type);
    return type;
  }

  /**
   * License feature
   */
  public static final ToolkitFeatureTypeInternal<LicenseFeature> LICENSE = define(LicenseFeature.class);

  /**
   * Returns list of all features that a toolkit can support.
   * 
   * @return array of toolkit feature types
   * @see Toolkit#getFeature(ToolkitFeatureType)
   */
  public static ToolkitFeatureTypeInternal[] values() {
    return features.toArray(new ToolkitFeatureTypeInternal[0]);
  }

  private final Class<T> clazz;

  private ToolkitFeatureTypeInternal(Class<T> clazz) {
    if (clazz == null) throw new AssertionError();
    this.clazz = clazz;
  }

  public Class<T> getFeatureClass() {
    return clazz;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ToolkitFeatureTypeInternal other = (ToolkitFeatureTypeInternal) obj;
    if (clazz == null) {
      if (other.clazz != null) return false;
    } else if (!clazz.equals(other.clazz)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "ToolkitFeatureType [clazz=" + clazz.getName() + "]";
  }

}
