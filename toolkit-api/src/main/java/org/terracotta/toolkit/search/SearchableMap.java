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
package org.terracotta.toolkit.search;

import org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor;

public interface SearchableMap<K, V> {

  /**
   * Set indexed attribute extractor. This map is considered searchable if this method has been called at least once.
   */
  void setAttributeExtractor(ToolkitAttributeExtractor<K, V> attrExtractor);

  /**
   * Create a new query builder to construct a search query tied to this map
   */
  QueryBuilder createQueryBuilder();
}
