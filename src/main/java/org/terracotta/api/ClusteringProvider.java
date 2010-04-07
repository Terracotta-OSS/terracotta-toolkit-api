package org.terracotta.api;

import java.util.concurrent.Callable;

import org.terracotta.cluster.TerracottaCluster;
import org.terracotta.logging.TerracottaLogger;
import org.terracotta.properties.TerracottaProperties;

public interface ClusteringProvider {

  <T> T lookupOrCreateRoot(String rootName, Callable<T> creator);

  void beginLock(String lockID, LockType type);

  void commitLock(String lockID, LockType type);

  void monitorEnter(Object obj, LockType type);

  void monitorExit(Object obj, LockType type);

  TerracottaCluster getCluster();
  
  /**
   * Disable eviction on the provided object in case it implements a Terracotta interface that supports this.
   * 
   * @param object the object on which eviction should be disabled
   * @return {@code true} when eviction could be disabled; or {@code false} otherwise
   */
  boolean disableEviction(Object object);
  
  /**
   * Enable eviction on the provided object in case it implements a Terracotta interface that supports this.
   * 
   * @param object the object on which eviction should be enabled
   * @return {@code true} when eviction could be enabled; or {@code false} otherwise
   */
  boolean enableEviction(Object object);
  
  void waitForAllCurrentTransactionsToComplete();
  
  void registerBeforeShutdownHook(Runnable beforeShutdownHook);
  
  String getClientID();
  
  String getUUID();
  
  TerracottaLogger getLogger(String name);
  
  TerracottaProperties getProperties();
}