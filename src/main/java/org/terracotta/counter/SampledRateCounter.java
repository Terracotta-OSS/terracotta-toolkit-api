/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.counter;

public interface SampledRateCounter extends SampledCounter {

  public void increment(long numerator, long denominator);

  public void decrement(long numerator, long denominator);

  public void setValue(long numerator, long denominator);
  
  public void setNumeratorValue(long newValue);
  
  public void setDenominatorValue(long newValue);

}
