package org.terracotta.counter;

import java.io.Serializable;

public interface TimeStampedCounterValue extends Serializable {

  long getCounterValue();

  long getTimestamp();
}