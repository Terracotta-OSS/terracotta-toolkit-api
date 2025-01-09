/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
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
