/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.cache;

/**
 * If a TimestampedValue is added to the Toolkit Map, Toolkit Map will internally update the last accessed time of the
 * value. It acts as a wrapper for Value and also provides accurate last access time.
 */
public interface TimestampedValue {

  void updateTimestamps(int createTime, int lastAccessedTime);

}
