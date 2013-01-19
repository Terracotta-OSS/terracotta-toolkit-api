/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import java.util.concurrent.TimeUnit;

public interface NonStopConfigurationFields {
  enum NonStopReadTimeoutBehavior {
    EXCEPTION, NO_OP, LOCAL_READS
  }

  enum NonStopWriteTimeoutBehavior {
    EXCEPTION, NO_OP
  }

  String                      NON_STOP_TIMEOUT_MILLIS                    = "nonStopTimeoutMillis";
  long                        DEFAULT_TIMEOUT_MILLIS                     = TimeUnit.SECONDS.toMillis(30L);

  String                      NON_STOP_DEFAULT_SEARCH_TIMEOUT_MILLIS     = "nonStopSearchTimeoutMillis";
  long                        DEFAULT_SEARCH_TIMEOUT_MILLIS              = TimeUnit.SECONDS.toMillis(30L);

  String                      NON_STOP_READ_OP_TIMEOUT_BEHAVIOR          = "nonStopReadOpTimeoutBehavior";
  NonStopReadTimeoutBehavior  DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR     = NonStopReadTimeoutBehavior.EXCEPTION;

  String                      NON_STOP_WRITE_OP_TIMEOUT_BEHAVIOR         = "nonStopWritesOpTimeoutBehavior";
  NonStopWriteTimeoutBehavior DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR    = NonStopWriteTimeoutBehavior.EXCEPTION;

  String                      NON_STOP_ENABLED                           = "nonStopEnabled";
  boolean                     DEFAULT_NON_STOP_ENABLED                   = true;

  String                      NON_STOP_IMMEDIATE_TIMEOUT_ENABLED         = "immediateTimeoutEnabled";
  boolean                     DEFAULT_NON_STOP_IMMEDIATE_TIMEOUT_ENABLED = false;
}
