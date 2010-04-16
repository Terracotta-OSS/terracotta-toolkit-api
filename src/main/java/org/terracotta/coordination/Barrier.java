package org.terracotta.coordination;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeoutException;

/**
 * Barriers serve as synchronization points for groups of threads that must occasionally wait for each other. Barriers
 * may support any of several methods that accomplish this synchronization. This interface merely expresses their
 * minimal commonalities:
 * <ul>
 * <li>Every barrier is defined for a given number of <code>parties</code> -- the number of threads that must meet at
 * the barrier point. (In all current implementations, this value is fixed upon construction of the Barrier.)
 * <li>A barrier can become <code>broken</code> if one or more threads leave a barrier point prematurely, generally due
 * to interruption or timeout. Corresponding synchronization methods in barriers fail, throwing BrokenBarrierException
 * for other threads when barriers are in broken states.
 * </ul>
 * <p>
 * [<a href="http://gee.cs.oswego.edu/dl/classes/EDU/oswego/cs/dl/util/concurrent/intro.html" > Introduction to this
 * package. </a>]
 **/
public interface Barrier {

  /**
   * Return the number of parties that must meet per barrier point. The number of parties is always at least 1.
   **/
  int getParties();

  /**
   * Returns true if the barrier has been compromised by threads leaving the barrier before a synchronization point
   * (normally due to interruption or timeout). Barrier methods in implementation classes throw throw
   * BrokenBarrierException upon detection of breakage. Implementations may also support some means to clear this
   * status.
   **/
  boolean isBroken();

  /**
   * Enter barrier and wait for the other parties()-1 threads.
   * 
   * @return the arrival index: the number of other parties that were still waiting upon entry. This is a unique value
   *         from zero to parties()-1. If it is zero, then the current thread was the last party to hit barrier point
   *         and so was responsible for releasing the others.
   * @exception BrokenBarrierException if any other thread in any previous or current barrier since either creation or
   *            the last <code>restart</code> operation left the barrier prematurely due to interruption or time-out.
   *            (If so, the <code>broken</code> status is also set.) Threads that are notified to have been interrupted
   *            <em>after</em> being released are not considered to have broken the barrier. In all cases, the
   *            interruption status of the current thread is preserved, so can be tested by checking
   *            <code>Thread.interrupted</code>.
   * @exception InterruptedException if this thread was interrupted during the barrier, and was the one causing
   *            breakage. If so, <code>broken</code> status is also set.
   **/
  int await() throws InterruptedException, BrokenBarrierException;
  
  /**
   * Enter barrier and wait at most msecs for the other parties()-1 threads.
   * 
   * @return if not timed out, the arrival index: the number of other parties that were still waiting upon entry. This
   *         is a unique value from zero to parties()-1. If it is zero, then the current thread was the last party to
   *         hit barrier point and so was responsible for releasing the others.
   * @exception BrokenBarrierException if any other thread in any previous or current barrier since either creation or
   *            the last <code>restart</code> operation left the barrier prematurely due to interruption or time-out.
   *            (If so, the <code>broken</code> status is also set.) Threads that are noticed to have been interrupted
   *            <em>after</em> being released are not considered to have broken the barrier. In all cases, the
   *            interruption status of the current thread is preserved, so can be tested by checking
   *            <code>Thread.interrupted</code>.
   * @exception InterruptedException if this thread was interrupted during the barrier. If so, <code>broken</code>
   *            status is also set.
   * @exception TimeoutException if this thread timed out waiting for the barrier. If the timeout occured while already
   *            in the barrier, <code>broken</code> status is also set.
   **/
  int await(long msecs) throws InterruptedException, TimeoutException, BrokenBarrierException;

  /**
   * Reset to initial state. Clears both the broken status and any record of waiting threads, and releases all currently
   * waiting threads with indeterminate return status. This method is intended only for use in recovery actions in which
   * it is somehow known that no thread could possibly be relying on the the synchronization properties of this barrier.
   **/
  void reset();
}
