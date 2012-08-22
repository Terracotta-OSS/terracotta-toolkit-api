/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.monitoring;

import org.terracotta.toolkit.tck.TCKStrict;

/**
 * An enum specifying the level of an operator event
 */
@TCKStrict
public enum OperatorEventLevel {
  INFO, WARN, DEBUG, ERROR, CRITICAL

}
