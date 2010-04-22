package org.terracotta.counter;

public interface CounterConfig {

  long getInitialValue();

  public Counter createCounter();
}