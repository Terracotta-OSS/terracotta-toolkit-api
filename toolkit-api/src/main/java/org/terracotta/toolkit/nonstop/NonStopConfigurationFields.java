/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;


public interface NonStopConfigurationFields {
  enum NonStopTimeoutBehavior {
    EXCEPTION_ON_TIMEOUT, NO_OP, LOCAL_READS
  }

  String                 NON_STOP_TIMEOUT_MILLIS                    = "nonStopTimeoutMillis";
  long                   DEFAULT_TIMEOUT_MILLIS                     = 60000;

  String                 NON_STOP_READ_TIMEOUT_BEHAVIOR             = "nonStopReadTimeoutBehavior";
  NonStopTimeoutBehavior DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR     = NonStopTimeoutBehavior.EXCEPTION_ON_TIMEOUT;

  String                 NON_STOP_WRITE_TIMEOUT_BEHAVIOR            = "nonStopWriteTimeoutBehavior";
  NonStopTimeoutBehavior DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR    = NonStopTimeoutBehavior.EXCEPTION_ON_TIMEOUT;


  String                 NON_STOP_ENABLED                           = "nonStopEnabled";
  boolean                DEFAULT_NON_STOP_ENABLED                   = true;

  String                 NON_STOP_IMMEDIATE_TIMEOUT_ENABLED         = "immediateTimeoutEnabled";
  boolean                DEFAULT_NON_STOP_IMMEDIATE_TIMEOUT_ENABLED = false;
}
