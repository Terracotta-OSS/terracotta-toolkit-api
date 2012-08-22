/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal;

/**
 * Logging interface implemented by loggers provided by the toolkit.
 */
public interface ToolkitLogger {
  /**
   * Log a message at the debug level.
   * 
   * @param message message to log
   */
  void debug(Object message);

  /**
   * Log a message at the debug level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void debug(Object message, Throwable t);

  /**
   * Log a message at the info level.
   * 
   * @param message message to log
   */
  void info(Object message);

  /**
   * Log a message at the info level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void info(Object message, Throwable t);

  /**
   * Log a message at the warn level.
   * 
   * @param message message to log
   */
  void warn(Object message);

  /**
   * Log a message at the warn level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void warn(Object message, Throwable t);

  /**
   * Log a message at the error level.
   * 
   * @param message message to log
   */
  void error(Object message);

  /**
   * Log a message at the error level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void error(Object message, Throwable t);

  /**
   * Log a message at the fatal level.
   * 
   * @param message message to log
   */
  void fatal(Object message);

  /**
   * Log a message at the fatal level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void fatal(Object message, Throwable t);

  /**
   * Returns {@code true} if debug level messages from this logger will be recorded.
   * 
   * @return {@code true} if debug logging is enabled
   */
  boolean isDebugEnabled();

  /**
   * Returns {@code true} if info level messages from this logger will be recorded.
   * 
   * @return {@code true} if info logging is enabled
   */
  boolean isInfoEnabled();

  /**
   * Returns the name of this logger.
   * 
   * @return name of this logger
   */
  String getName();
}
