/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.collections;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.ToolkitLockedObject;
import org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException;

import java.util.SortedSet;

/**
 * A toolkit sorted set. The sorted set performs all mutative operations under the write lock from
 * {@link ToolkitLockedObject#getReadWriteLock()} and all read operations under the read lock from the same. Objects are
 * sorted according to the {@linkplain Comparable natural ordering} of the values. The values should implement
 * {@link Comparable}
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 * <p>
 * Trying to add values that are not serializable will throw {@link NotSerializableRuntimeException}
 */
public interface ToolkitSortedSet<E extends Comparable<? super E>> extends SortedSet<E>, ToolkitSet<E> {
  // no extra methods
}
