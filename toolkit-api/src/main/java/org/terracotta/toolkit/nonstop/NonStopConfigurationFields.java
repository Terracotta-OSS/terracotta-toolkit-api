/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

  String                      NON_STOP_SEARCH_TIMEOUT_MILLIS             = "nonStopSearchTimeoutMillis";
  long                        DEFAULT_SEARCH_TIMEOUT_MILLIS              = DEFAULT_TIMEOUT_MILLIS;

  String                      NON_STOP_READ_OP_TIMEOUT_BEHAVIOR          = "nonStopReadOpTimeoutBehavior";
  NonStopReadTimeoutBehavior  DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR     = NonStopReadTimeoutBehavior.EXCEPTION;

  String                      NON_STOP_WRITE_OP_TIMEOUT_BEHAVIOR         = "nonStopWritesOpTimeoutBehavior";
  NonStopWriteTimeoutBehavior DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR    = NonStopWriteTimeoutBehavior.EXCEPTION;

  String                      NON_STOP_ENABLED                           = "nonStopEnabled";
  boolean                     DEFAULT_NON_STOP_ENABLED                   = true;

  String                      NON_STOP_IMMEDIATE_TIMEOUT_ENABLED         = "immediateTimeoutEnabled";
  boolean                     DEFAULT_NON_STOP_IMMEDIATE_TIMEOUT_ENABLED = false;
}
