package org.terracotta.api;

/**
 * Enum that contains the  lock types that are supported by Terracotta DSO.
 *
 * @author Geert Bevin
 */
public enum LockType {
  /**
   * Asynchronously flush changes to the Terracotta Server Array.
   */
  WRITE,

  /**
   * Synchronously flush changes to the Terracotta Server Array, blocking the calling method until data has been
   * acknowledged as being committed.
   */
  SYNCHRONOUS_WRITE,

  /**
   * Read locks going up to the Terracotta Server Array.
   */
  READ,

  /**
   * Dirty writes and dirty reads that only gives transaction boundaries and no exclusion. Use at your own risk.
   */
  CONCURRENT;
}