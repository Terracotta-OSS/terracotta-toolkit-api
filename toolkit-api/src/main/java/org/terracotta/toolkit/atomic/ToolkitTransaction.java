/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.atomic;


public interface ToolkitTransaction {

  /**
   * Commit the current transaction.
   * 
   * @see ToolkitTransactionController
   */
  public void commit();
}
