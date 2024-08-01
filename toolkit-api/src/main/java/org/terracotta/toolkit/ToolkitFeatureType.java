/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.toolkit;

import org.terracotta.toolkit.feature.NonStopFeature;
import org.terracotta.toolkit.feature.OffheapFeature;
import org.terracotta.toolkit.feature.SearchFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * List of features that a toolkit implementation can support.
 */
public final class ToolkitFeatureType<T extends ToolkitFeature> {

  private static final List<ToolkitFeatureType> features = new ArrayList<ToolkitFeatureType>();

  private static <F extends ToolkitFeature> ToolkitFeatureType<F> define(Class<F> clazz) {
    ToolkitFeatureType type = new ToolkitFeatureType(clazz);
    if (features.contains(type)) {
      throw new AssertionError("Cannot define multiple times for same feature interface - " + clazz.getName());
    }
    features.add(type);
    return type;
  }

  /**
   * Offheap feature
   */
  public static final ToolkitFeatureType<OffheapFeature> OFFHEAP = define(OffheapFeature.class);
  /**
   * Search feature
   */
  public static final ToolkitFeatureType<SearchFeature>  SEARCH  = define(SearchFeature.class);
  /**
   * Nonstop feature
   */
  public static final ToolkitFeatureType<NonStopFeature> NONSTOP = define(NonStopFeature.class);

  /**
   * Returns list of all features that a toolkit can support.
   * 
   * @return array of toolkit feature types
   * @see Toolkit#getFeature(ToolkitFeatureType)
   */
  public static ToolkitFeatureType[] values() {
    return features.toArray(new ToolkitFeatureType[0]);
  }

  private final Class<T> clazz;

  private ToolkitFeatureType(Class<T> clazz) {
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
    ToolkitFeatureType other = (ToolkitFeatureType) obj;
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
