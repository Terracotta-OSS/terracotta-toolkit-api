/*
 * All content copyright (c) 2003-2008 Terracotta, Inc., except as may otherwise be noted in a separate copyright notice.  All rights reserved.
 */
package org.terracotta.counter;

import org.terracotta.counter.Counter;

public interface SampledCounter extends Counter {
  
  void shutdown();
  
  TimeStampedCounterValue getMostRecentSample();

  TimeStampedCounterValue[] getAllSampleValues();

  long getAndReset();
}
