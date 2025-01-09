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
package org.terracotta.toolkit.concurrent.locks;

import org.terracotta.toolkit.object.ToolkitObject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Provides primitive lock operations for the given {@link ToolkitLockType} that was used to create an instance of this
 * lock. Multiple instances having the same {@linkplain ToolkitObject#getName() name} behave as same lock.
 */
public interface ToolkitLock extends Lock, ToolkitObject {

  /**
   * Always throws {@code UnsupportedOperationException}. ToolkitLock supports one condition per lock which can be
   * obtained by using method getCondition()
   * 
   * @return does not return anything
   * @throws UnsupportedOperationException always throws this exception
   */
  @Override
  Condition newCondition() throws UnsupportedOperationException;

  /**
   * Returns the Condition associated with the Lock. This is optional operation and some implementation may throw
   * {@code UnsupportedOperationException}. e.g. for read level locks
   * 
   * @return condition associated with the lock
   */
  Condition getCondition();

  /**
   * Return the {@link ToolkitLockType} for this Lock.
   * 
   * @return the lock type of this lock
   */
  ToolkitLockType getLockType();

  /**
   * Indicates whether the current thread is holding this lock for {@link #getLockType()}.
   * 
   * @return returns true if current thread is holding this lock for {@link #getLockType()}
   */
  public boolean isHeldByCurrentThread();

}
