/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.attribute;

import java.util.Map;

/**
 * Adapter class to indicate non-indexability of underlying data structure
 */
public class NullAttributeExtractor<K, V> implements ToolkitAttributeExtractor<K, V> {
  NullAttributeExtractor() {
    // don't instantiate from outside
  }
  @Override
  public Map<String, Object> attributesFor(K key, V value) {
    return DO_NOT_INDEX;
  }

}
