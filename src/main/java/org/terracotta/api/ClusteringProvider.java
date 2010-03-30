package org.terracotta.api;

import java.util.concurrent.Callable;

import org.terracotta.cluster.TerracottaCluster;

public interface ClusteringProvider {

  <T> T lookupOrCreateRoot(String rootName, Callable<T> creator);

  void beginLock(String lockID, LockType type);

  void commitLock(String lockID, LockType type);

  void monitorEnter(Object obj, LockType type);

  void monitorExit(Object obj, LockType type);

  TerracottaCluster getTerracottaCluster();
}