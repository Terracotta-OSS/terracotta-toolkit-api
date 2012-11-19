/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

public interface NonStopConfigurationFields {
  enum NonStopTimeoutBehavior {
    EXCEPTION_ON_TIMEOUT, NO_OP, LOCAL_READS, EXCEPTION_ON_MUTATE_AND_LOCAL_READS
  }

  enum WriteTimeoutBehavior {
    EXCEPTION_ON_TIMEOUT, NO_OP
  }

  String                 NON_STOP_TIMEOUT_MILLIS           = "nonStopTimeoutMillis";
  long                   DEFAULT_TIMEOUT_MILLIS            = 0;

  String                 NON_STOP_TIMEOUT_BEHAVIOR         = "nonStopTimeoutBehavior";
  NonStopTimeoutBehavior DEFAULT_NON_STOP_TIMEOUT_BEHAVIOR = NonStopTimeoutBehavior.EXCEPTION_ON_TIMEOUT;

  String                 NON_STOP_ENABLED                  = "nonStopEnabled";
  boolean                DEFAULT_NON_STOP_ENABLED          = true;
}
