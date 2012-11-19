/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

public interface NonStopConfigurationFields {
  enum ReadTimeoutBehavior {
    EXCEPTION_ON_TIMEOUT, NO_OP, LOCAL_READS
  }

  enum WriteTimeoutBehavior {
    EXCEPTION_ON_TIMEOUT, NO_OP
  }

  String               NON_STOP_TIMEOUT_MILLIS                 = "nonStopTimeoutMillis";
  long                 DEFAULT_TIMEOUT_MILLIS                  = 0;

  String               NON_STOP_TIMEOUT_READ_BEHAVIOR          = "nonStopTimeoutReadBehavior";
  ReadTimeoutBehavior  DEFAULT_NON_STOP_TIMEOUT_READ_BEHAVIOR  = ReadTimeoutBehavior.EXCEPTION_ON_TIMEOUT;

  String               NON_STOP_TIMEOUT_WRITE_BEHAVIOR         = "nonStopTimeoutWriteBehavior";
  WriteTimeoutBehavior DEFAULT_NON_STOP_TIMEOUT_WRITE_BEHAVIOR = WriteTimeoutBehavior.EXCEPTION_ON_TIMEOUT;

  String               NON_STOP_ENABLED                        = "nonStopEnabled";
  boolean              DEFAULT_NON_STOP_ENABLED                = true;
}
