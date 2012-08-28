/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.collections;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitLockedObject;
import org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException;

import java.util.SortedMap;

/**
 * A toolkit sorted map. The sorted map performs all mutative operations under the write lock from
 * {@link ToolkitLockedObject#getReadWriteLock()} and all read operations under the read lock from the same. Keys are
 * sorted according to the {@linkplain Comparable natural ordering} of the keys. The keys should implement
 * {@link Comparable}
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 * <p>
 * Trying to add values that are not serializable will throw {@link NotSerializableRuntimeException}
 */
public interface ToolkitSortedMap<K extends Comparable<? super K>, V> extends SortedMap<K, V>, ToolkitLockedObject,
    Destroyable {
  // no extra methods
}
