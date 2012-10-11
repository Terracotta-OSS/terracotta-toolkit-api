/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

import org.terracotta.toolkit.api.ToolkitFactoryService;
import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.cache.ToolkitCacheConfigFields;
import org.terracotta.toolkit.cluster.ClusterInfo;
import org.terracotta.toolkit.collections.ToolkitBlockingQueue;
import org.terracotta.toolkit.collections.ToolkitList;
import org.terracotta.toolkit.collections.ToolkitMap;
import org.terracotta.toolkit.collections.ToolkitSet;
import org.terracotta.toolkit.collections.ToolkitSortedMap;
import org.terracotta.toolkit.collections.ToolkitSortedSet;
import org.terracotta.toolkit.concurrent.ToolkitBarrier;
import org.terracotta.toolkit.concurrent.atomic.ToolkitAtomicLong;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.concurrent.locks.ToolkitLockType;
import org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.events.ToolkitNotifier;
import org.terracotta.toolkit.monitoring.OperatorEventLevel;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitLockedObject;
import org.terracotta.toolkit.object.ToolkitObject;
import org.terracotta.toolkit.store.ToolkitStore;
import org.terracotta.toolkit.store.ToolkitStoreConfigFields;

/**
 * A toolkit that provides various data-structures. A {@code Toolkit} can be constructed using one of the factory
 * methods provided in {@code ToolkitFactory}. See {@link ToolkitFactory} for more details on how to instantiate a
 * toolkit.
 * <p>
 * All object instances constructed using the toolkit are always identified by a {@link ToolkitObject#getName() name}
 * and a {@link ToolkitObject#getType() toolkit object type}. Some instances can be destroyed, and in such cases the
 * objects will also be instance of {@link Destroyable}. Some instances also perform lock-based mutate and read
 * operations based on a read-write lock associated with the instance, these are instances of
 * {@link ToolkitLockedObject}. There are certain optional features in the toolkit denoted by {@link ToolkitCapability}.
 * Certain implementations can support these features while some can throw {@code UnsupportedOperationException}. Users
 * can use {@link #isCapabilityEnabled(ToolkitCapability)} at runtime to query whether the specific feature is enabled
 * or not. Some toolkit implementations can be distributed in nature, for example Terracotta clustered toolkits, and in
 * such cases can support the {@link #getClusterInfo()} api. Toolkit implementations that are not distributed in nature
 * can throw {@code UnsupportedOperationException} for the same. Toolkit implementors can also choose to implement
 * operator events, for easy monitoring, and support the {@link #fireOperatorEvent(OperatorEventLevel, String, String)}
 * or otherwise throw {@code UnsupportedOperationException}.
 * <p>
 * <h2>Destroy Behavior</h2> Toolkit objects that can be destroyed are instances of {@link Destroyable} and once
 * destroyed cannot be reused. Attempting to use an object after getting destroyed will result in
 * {@code IllegalStateException} except for {@link ToolkitObject#getName()}. In toolkit implementations which are
 * distributed in nature, like Terracotta clustered toolkits, destroying an object in one node will destroy it from all
 * the nodes in the cluster, attempting to use the destroyed instance in any other node will also result in
 * {@code IllegalStateException}. It is though possible to reuse the same name of an already destroyed instance by
 * calling the corresponding Toolkit.getXXX(String name) method with the same name. The new object references thus
 * obtained will work, while the old references that pointed to the 'destroyed' object instance will throw
 * {@code IllegalStateException}.
 * <p>
 * For those who want to implement the toolkit should consult {@link ToolkitFactoryService}.
 */
public interface Toolkit {

  /**
   * Returns an already created {@link ToolkitList} if one exists for the given {@code name} parameter, otherwise
   * creates one and returns it.
   * <p>
   * Toolkit lists are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs} for
   * more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <E> list element type
   * @param name identifier of the list
   * @param klazz concrete class for {@code <E>}
   * @return a toolkit list
   */
  <E> ToolkitList<E> getList(String name, Class<E> klazz);

  /**
   * Returns an already created {@link ToolkitStore} if one exists for the given 'name' parameter, otherwise creates one
   * using the 'configuration' parameter and returns it. Subsequent calls to getStore() with same name will return same
   * key-value store. The {@code configuration} parameter can take various config. Keys in the mapping can take values
   * declared in {@link ToolkitStoreConfigFields}. Behavior of the various configs are detailed in below table:
   * <blockquote>
   * <table border="0" cellspacing="3" cellpadding="0">
   * <tr bgcolor="#ccccff">
   * <th rowspan="2">Configuration Field</th>
   * <th rowspan="2">Default Value</th>
   * <th colspan="2">Instance exists in Cluster already</th>
   * <th colspan="2">Instance does NOT exist in Cluster yet</th>
   * </tr>
   * <tr bgcolor="#ccccff">
   * <th >value passed in config</th>
   * <th >value NOT passed in config</th>
   * <th >value passed in config</th>
   * <th >value NOT passed in config</th>
   * </tr>
   * <tr bgcolor="#eeeeff">
   * <td>CONSISTENCY</td>
   * <td >EVENTUAL</td>
   * <td >{@code IllegalArgumentException} on mismatch</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr>
   * <td>CONCURRENCY</td>
   * <td >256</td>
   * <td >{@code IllegalArgumentException} on mismatch</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr bgcolor="#eeeeff">
   * <td>MAX_COUNT_LOCAL_HEAP</td>
   * <td >0</td>
   * <td >Use local value for first time in same node, throws {@code IllegalArgumentException} on mismatch thereafter</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr>
   * <td>MAX_BYTES_LOCAL_HEAP</td>
   * <td >0</td>
   * <td >Use local value for first time in same node, throws {@code IllegalArgumentException} on mismatch thereafter</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr bgcolor="#eeeeff">
   * <td>MAX_BYTES_LOCAL_OFF_HEAP</td>
   * <td >0</td>
   * <td >Use local value for first time in same node, throws {@code IllegalArgumentException} on mismatch thereafter</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr>
   * <td>OFF_HEAP_ENABLED</td>
   * <td >false</td>
   * <td >Use local value for first time in same node, throws {@code IllegalArgumentException} on mismatch thereafter</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr bgcolor="#eeeeff">
   * <td >LOCAL_CACHE_ENABLED</td>
   * <td >true</td>
   * <td >Use local value for first time in same node, throws {@code IllegalArgumentException} on mismatch thereafter</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * </table>
   * </blockquote>
   * <p>
   * Toolkit key-value stores are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level
   * docs} for more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <V> store value type
   * @param name identifier for the key-value store
   * @param configuration configuration with which the key-value store is to be created
   * @param klazz concrete class for {@code <V>}
   * @return a toolkit key-value store
   */
  <V> ToolkitStore<String, V> getStore(String name, Configuration configuration, Class<V> klazz);

  /**
   * Returns an already created {@link ToolkitStore} if one exists for the given {@code name}, otherwise creates one and
   * returns it. It uses a default Toolkit Store config and is effectively same as below:
   * 
   * <pre>
   * public ToolkitStore getStore(String name) {
   *   return getStore(name, new ToolkitStoreConfigBuilder().build());
   * }
   * </pre>
   * <p>
   * Toolkit key-value stores are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level
   * docs} for more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <V> store value type
   * @param name identifier for the key-value store
   * @param klazz concrete class for {@code <V>}
   * @return a toolkit key-value store with default configuration
   */
  <V> ToolkitStore<String, V> getStore(String name, Class<V> klazz);

  /**
   * Returns an already created {@link ToolkitMap} if one exists for the given {@code name}, otherwise creates one and
   * returns it.
   * <p>
   * Toolkit maps are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs} for
   * more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <K> map key type
   * @param <V> map value type
   * @param name identifier for the map
   * @param keyKlazz concrete class for {@code <K>}
   * @param valueKlazz concrete class for {@code <V>}
   * @return a toolkit map
   */
  <K, V> ToolkitMap<K, V> getMap(String name, Class<K> keyKlazz, Class<V> valueKlazz);

  /**
   * Returns an already created {@link ToolkitSortedMap} if one exists for the given {@code name}, otherwise creates one
   * and returns it.
   * <p>
   * Toolkit Sorted maps are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs}
   * for more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <K> map key type
   * @param <V> map value type
   * @param name identifier for the map
   * @param keyKlazz concrete class for {@code <K>}
   * @param valueKlazz concrete class for {@code <V>}
   * @return a toolkit map
   */
  <K extends Comparable<? super K>, V> ToolkitSortedMap<K, V> getSortedMap(String name, Class<K> keyKlazz,
                                                                           Class<V> valueKlazz);

  /**
   * Get or create a toolkit blocking queue with a capacity limit for the given {@code name}.
   * <p>
   * If the named queue already exists and it has the same capacity limit then it is returned. If it doesn't exist then
   * it is created and registered. If the named queue already exists but has a different capacity limit then
   * {@code IllegalArgumentException} is thrown. <br>
   * NOTE: {@code Integer.MAX_VALUE} is a valid capacity and it does NOT mean unbounded queue.
   * <p>
   * Toolkit queues are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs} for
   * more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <E> queue element type
   * @param name identifier for the queue
   * @param capacity the capacity limit for the queue
   * @param klazz concrete class for {@code <E>}
   * @return a capacity bounded toolkit blocking queue
   * @throws IllegalArgumentException if there is an existing queue of same {@code name} with a different capacity limit
   * @throws IllegalArgumentException if {@code capacity} is less than 1.
   */
  <E> ToolkitBlockingQueue<E> getBlockingQueue(String name, int capacity, Class<E> klazz);

  /**
   * Get or create a toolkit blocking queue for the given {@code name}. This is same as calling
   * {@code Toolkit.getBlockingQueue(name, Integer.MAX_VALUE)}
   * <p>
   * See {@link #getBlockingQueue(String, int, Class<E>)}.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <E> queue element type
   * @param name identifier of the queue
   * @param klazz concrete class for {@code <E>}
   * @return a toolkit blocking queue
   * @throws IllegalArgumentException if there is an existing queue with different capacity limit
   */
  <E> ToolkitBlockingQueue<E> getBlockingQueue(String name, Class<E> klazz);

  /**
   * Gets the {@link ClusterInfo} associated with the toolkit. If the implementation of the toolkit is not distributed
   * in nature and not associated with a cluster, the implementation is free to either throw
   * {@code UnsupportedOperationException} or return no-op implementations.
   * 
   * @return the cluster info
   */
  ClusterInfo getClusterInfo();

  /**
   * Get a reentrant toolkit {@linkplain ToolkitLockType#WRITE write lock} of the specified {@code name}. Multiple
   * instances having the same {@linkplain ToolkitObject#getName() name} behave as same lock.
   * <p>
   * NOTE: This is different from the both the read/write locks obtained using {@link ToolkitReadWriteLock#writeLock()}
   * and {@link ToolkitReadWriteLock#readLock()} from the read-write lock using {@link #getReadWriteLock(String)} even
   * with same name for the read-write lock.
   * 
   * @param name identifier for the lock
   * @return a toolkit lock
   */
  ToolkitLock getLock(String name);

  /**
   * Get a reentrant toolkit read-write lock for the given {@code name}. Multiple instances having the same
   * {@linkplain ToolkitObject#getName() name} behave as same lock.
   * <p>
   * NOTE: The lock returned from {@link ToolkitReadWriteLock#writeLock()} is different from the one using
   * {@link #getLock(String)} even with same name.
   * 
   * @param name identifier for the lock
   * @return a toolkit read-write lock
   */
  ToolkitReadWriteLock getReadWriteLock(String name);

  /**
   * Gets or creates a {@link ToolkitNotifier} for the given {@code name} parameter.
   * <p>
   * Toolkit notifiers are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs}
   * for more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <E> notifier message type
   * @param name identifier for the notifier
   * @param klazz concrete class for {@code <E>}
   * @return a toolkit notifier
   */
  <E> ToolkitNotifier<E> getNotifier(String name, Class<E> klazz);

  /**
   * Returns a {@link ToolkitAtomicLong} for the given {@code name} parameter.
   * <p>
   * Toolkit atomic longs are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level
   * docs} for more info on behavior regarding destroy.
   * 
   * @param name identifier for the AtomicLong
   * @return a toolkit atomic long
   */
  ToolkitAtomicLong getAtomicLong(String name);

  /**
   * Returns a {@link ToolkitBarrier} for the given {@code name} and specified parties.
   * <p>
   * If the barrier already exists with the same name and parties then it is returned. If it doesn't exist then it is
   * created and registered. If the toolkit barrier already exists but has a different parties then
   * {@code IllegalArgumentException} is thrown.
   * <p>
   * Toolkit barriers are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs}
   * for more info on behavior regarding destroy.
   * 
   * @param name identifier for the toolkit barrier
   * @param parties the parties involved in the barrier
   * @return a toolkit barrier
   * @throws IllegalArgumentException if there is an existing barrier with different number of parties with same name
   * @throws IllegalArgumentException if {@code parties} is less than 1
   */
  ToolkitBarrier getBarrier(String name, int parties);

  /**
   * Fires an application specific Operator Event with the specified {@link OperatorEventLevel} and eventMessage. This
   * is optional and implementations can throw {@code UnsupportedOperationException} or choose to ignore.
   * 
   * @param level level of the operator event
   * @param applicationName name of the application which is firing the event
   * @param eventMessage message content of the event
   */
  public void fireOperatorEvent(OperatorEventLevel level, String applicationName, String eventMessage);

  /**
   * Returns an already created {@link ToolkitSortedSet} if one exists for the given {@code name} parameter, otherwise
   * creates one and returns it. All elements inserted into the set must implement the {@link Comparable} interface.
   * <p>
   * Toolkit sorted sets are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs}
   * for more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <E> set element type
   * @param name identifier for the sorted set
   * @param klazz concrete class for {@code <E>}
   * @return a toolkit sorted set
   */
  <E extends Comparable<? super E>> ToolkitSortedSet<E> getSortedSet(String name, Class<E> klazz);

  /**
   * Returns an already created {@link ToolkitSet} if one exists for the given {@code name} parameter, otherwise creates
   * one and returns it.
   * <p>
   * Toolkit sets are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs} for
   * more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <E> set element type
   * @param name name of the set
   * @param klazz concrete class for {@code <E>}
   * @return a toolkit set
   */
  <E> ToolkitSet<E> getSet(String name, Class<E> klazz);

  /**
   * Returns an already created {@link ToolkitCache} if one exists for the given {@code name} parameter, otherwise
   * creates one using the {@code configuration} parameter and returns it. Subsequent calls with same name will return
   * same cache. The {@code configuration} parameter can take various config. Keys in the mapping can take values
   * declared in {@link ToolkitStoreConfigFields} or {@link ToolkitCacheConfigFields}. Refer to {@link
   * Toolkit#getStore(String, Configuration, Class<V>)} for behavior of various key-value store config fields. Behavior
   * of the other cache configs are detailed in below table: <blockquote>
   * <table border="0" cellspacing="3" cellpadding="0">
   * <tr bgcolor="#ccccff">
   * <th rowspan="2">Configuration Field</th>
   * <th rowspan="2">Default Value</th>
   * <th colspan="2">Instance exists in Cluster already</th>
   * <th colspan="2">Instance does NOT exist in Cluster yet</th>
   * </tr>
   * <tr bgcolor="#ccccff">
   * <th >value passed in config</th>
   * <th >value NOT passed in config</th>
   * <th >value passed in config</th>
   * <th >value NOT passed in config</th>
   * </tr>
   * <tr bgcolor="#eeeeff">
   * <td>MAX_TTI_SECONDS</td>
   * <td >0</td>
   * <td >{@code IllegalArgumentException} on mismatch</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr>
   * <td>MAX_TTL_SECONDS</td>
   * <td >0</td>
   * <td >{@code IllegalArgumentException} on mismatch</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr bgcolor="#eeeeff">
   * <td>MAX_TOTAL_COUNT</td>
   * <td >0</td>
   * <td >{@code IllegalArgumentException} on mismatch</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * <tr>
   * <td>PINNING_STORE</td>
   * <td >NONE</td>
   * <td >{@code IllegalArgumentException} on mismatch</td>
   * <td >Use existing value</td>
   * <td >Use value passed in config</td>
   * <td >Use default value</td>
   * </tr>
   * </table>
   * </blockquote>
   * <p>
   * Toolkit caches are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs} for
   * more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <V> cache value type
   * @param name identifier for the cache
   * @param configuration configuration with which the cache is to be created
   * @param klazz concrete class for {@code <V>}
   * @return a toolkit cache
   */
  <V> ToolkitCache<String, V> getCache(String name, Configuration configuration, Class<V> klazz);

  /**
   * Returns an already created {@link ToolkitCache} if one exists for the given {@code name}, otherwise creates one and
   * returns it. It uses a default config and is effectively same as below:
   * 
   * <pre>
   * public ToolkitCache getCache(String name) {
   *   return getCache(name, new ToolkitCacheConfigBuilder().build());
   * }
   * </pre>
   * <p>
   * Toolkit caches are {@link Destroyable} and can be destroyed. Consult the {@linkplain Toolkit class level docs} for
   * more info on behavior regarding destroy.
   * <p>
   * Implementations may choose to use the concrete class references to help enforce type safety of the returned data
   * structure. Users can pass {@code null} class references in order to disable any implementation specific type
   * checking and thereby gain raw access to the data structure.
   * 
   * @param <V> cache value type
   * @param name identifier for the cache
   * @param klazz concrete class for {@code <V>}
   * @return a toolkit cache with default config
   */
  <V> ToolkitCache<String, V> getCache(String name, Class<V> klazz);

  /**
   * Returns true if the capability is enabled and can be used. Otherwise returns false
   * 
   * @param capability capability which needs to be checked
   * @return true if the capability is enabled and can be used. Otherwise false
   */
  boolean isCapabilityEnabled(String capability);

  /**
   * Shut down toolkit and release resources associated with the toolkit. Multiple calls do not have any effect and are
   * ignored.
   */
  void shutdown();
}
