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

import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.collections.ToolkitBlockingQueue;
import org.terracotta.toolkit.collections.ToolkitList;
import org.terracotta.toolkit.collections.ToolkitMap;
import org.terracotta.toolkit.collections.ToolkitSet;
import org.terracotta.toolkit.collections.ToolkitSortedSet;
import org.terracotta.toolkit.concurrent.ToolkitBarrier;
import org.terracotta.toolkit.concurrent.atomic.ToolkitAtomicLong;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock;
import org.terracotta.toolkit.events.ToolkitNotifier;
import org.terracotta.toolkit.store.ToolkitStore;

/**
 * Type of toolkit objects
 */
public enum ToolkitObjectType {

  /**
   * {@link ToolkitList}
   */
  LIST,
  /**
   * {@link ToolkitMap}
   */
  MAP,
  /**
   * {@link ToolkitMap}
   */
  SORTED_MAP,
  /**
   * {@link ToolkitStore}
   */
  STORE,
  /**
   * {@link ToolkitCache}
   */
  CACHE,
  /**
   * {@link ToolkitBlockingQueue}
   */
  BLOCKING_QUEUE,
  /**
   * {@link ToolkitLock}
   */
  LOCK,
  /**
   * {@link ToolkitReadWriteLock}
   */
  READ_WRITE_LOCK,
  /**
   * {@link ToolkitNotifier}
   */
  NOTIFIER,
  /**
   * {@link ToolkitAtomicLong}
   */
  ATOMIC_LONG,
  /**
   * {@link ToolkitBarrier}
   */
  BARRIER,
  /**
   * {@link ToolkitSortedSet}
   */
  SORTED_SET,
  /**
   * {@link ToolkitSet}
   */
  SET;
}
