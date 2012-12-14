/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

public interface NonStopConfigurationFields {
  enum NonStopTimeoutBehavior {
    EXCEPTION_ON_TIMEOUT, NO_OP, LOCAL_READS
  }

  String                 NON_STOP_TIMEOUT_MILLIS                    = "nonStopTimeoutMillis";
  long                   DEFAULT_TIMEOUT_MILLIS                     = Long.MAX_VALUE;

  String                 NON_STOP_IMMUTABLE_OP_TIMEOUT_BEHAVIOR     = "nonStopImmutableOpTimeoutBehavior";
  NonStopTimeoutBehavior DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR     = NonStopTimeoutBehavior.EXCEPTION_ON_TIMEOUT;

  String                 NON_STOP_MUTABLE_OP_TIMEOUT_BEHAVIOR       = "nonStopMutableOpTimeoutBehavior";
  NonStopTimeoutBehavior DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR    = NonStopTimeoutBehavior.EXCEPTION_ON_TIMEOUT;

  String                 NON_STOP_ENABLED                           = "nonStopEnabled";
  boolean                DEFAULT_NON_STOP_ENABLED                   = true;

  String                 NON_STOP_IMMEDIATE_TIMEOUT_ENABLED         = "immediateTimeoutEnabled";
  boolean                DEFAULT_NON_STOP_IMMEDIATE_TIMEOUT_ENABLED = false;
}
