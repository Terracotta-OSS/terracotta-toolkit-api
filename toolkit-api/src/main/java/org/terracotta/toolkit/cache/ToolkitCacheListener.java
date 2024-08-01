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
package org.terracotta.toolkit.cache;

/**
 * A listener that can be added to {@link ToolkitCache} and get notified on eviction and expiration events
 */
public interface ToolkitCacheListener<K> {

  /**
   * Called when the key gets evicted from the cache
   */
  public void onEviction(K key);

  /**
   * Called when the key gets expired from the cache
   */
  public void onExpiration(K key);
}
