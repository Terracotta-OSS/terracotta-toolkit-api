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
package org.terracotta.toolkit.concurrent;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitObject;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A toolkit barrier that can be used to coordinate between threads in the toolkit implementation platform. Similar to
 * {@link CyclicBarrier} in nature.
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 */
public interface ToolkitBarrier extends Destroyable, ToolkitObject {

  /**
   * Returns the number of parties required to trip this barrier.
   * 
   * @return the number of parties required to trip this barrier
   */
  int getParties();

  /**
   * Queries if this barrier is in a broken state.
   * 
   * @return {@code true} if one or more parties broke out of this barrier due to interruption or timeout since
   *         construction or the last reset, or a barrier action failed due to an exception; {@code false} otherwise.
   **/
  boolean isBroken();

  /**
   * Waits until all {@linkplain #getParties parties} have invoked <tt>await</tt> on this barrier.
   * 
   * @return the arrival index of the current thread, where index <tt>{@link #getParties()} - 1</tt> indicates the first
   *         to arrive and zero indicates the last to arrive
   * @throws InterruptedException if the current thread was interrupted while waiting
   * @throws BrokenBarrierException if <em>another</em> thread was interrupted or timed out while the current thread was
   *         waiting, or the barrier was reset, or the barrier was broken when {@code await} was called, or the barrier
   *         action (if present) failed due an exception.
   **/
  int await() throws InterruptedException, BrokenBarrierException;

  /**
   * Waits until all {@linkplain #getParties parties} have invoked <tt>await</tt> on this barrier, or the specified
   * waiting time elapses.
   * 
   * @param timeout the time to wait for the barrier
   * @param unit the time unit of the timeout parameter
   * @return the arrival index of the current thread, where index <tt>{@link #getParties()} - 1</tt> indicates the first
   *         to arrive and zero indicates the last to arrive
   * @throws InterruptedException if the current thread was interrupted while waiting
   * @throws TimeoutException if the specified timeout elapses
   * @throws BrokenBarrierException if <em>another</em> thread was interrupted or timed out while the current thread was
   *         waiting, or the barrier was reset, or the barrier was broken when {@code await} was called, or the barrier
   *         action (if present) failed due an exception
   **/
  int await(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, BrokenBarrierException;

  /**
   * Reset to initial state. Clears both the broken status and any record of waiting threads, and releases all currently
   * waiting threads with indeterminate return status. This method is intended only for use in recovery actions in which
   * it is somehow known that no thread could possibly be relying on the the synchronization properties of this barrier.
   **/
  void reset();
}
