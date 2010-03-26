package org.terracotta.api;

import org.terracotta.cluster.TerracottaCluster;

import java.util.concurrent.Callable;

public interface ClusteringProvider {

  <T> T lookupOrCreateRoot(String rootName, Callable<T> createCallback);

  void beginLock(String lockID, LockType type);

  void commitLock(String lockID, LockType type);

  void monitorEnter(Object obj, LockType type);

  void monitorExit(Object obj, LockType type);

  TerracottaCluster getTerracottaCluster();
}