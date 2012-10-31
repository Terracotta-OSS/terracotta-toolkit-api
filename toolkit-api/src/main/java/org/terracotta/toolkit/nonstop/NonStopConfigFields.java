/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

public interface NonStopConfigFields {
  enum NonStopTimeoutBehavior {
    EXCEPTION_ON_TIMEOUT, LOCAL_READS, EXCEPTION_ON_MUTATE_AND_LOCAL_READS, NO_OP
  }

  String                 NON_STOP_TIMEOUT_MILLIS           = "nonStopTimeoutMillis";
  long                   DEFAULT_TIMEOUT_MILLIS            = 0;

  String                 NON_STOP_TIMEOUT_BEHAVIOR         = "nonStopTimeoutBehavior";
  NonStopTimeoutBehavior DEFAULT_NON_STOP_TIMEOUT_BEHAVIOR = NonStopTimeoutBehavior.EXCEPTION_ON_TIMEOUT;
}
