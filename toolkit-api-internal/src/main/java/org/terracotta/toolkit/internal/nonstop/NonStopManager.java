/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.nonstop;

public interface NonStopManager {

  /**
   * begin a non stop operation with a timeout
   */
  void begin(long timeout);

  /**
   * Indicate that the non stop operation completed
   */
  void finish();

  /**
   * return true If a nonstop operation is started.
   */
  boolean isBegin();

}