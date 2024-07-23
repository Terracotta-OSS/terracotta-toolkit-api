/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.collections;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitLockedObject;
import org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException;

import java.util.List;

/**
 * A toolkit list. It supports the contract of {@link java.util.List} and doesn't support null elements. The list
 * performs all mutative operations under the write lock from {@link ToolkitLockedObject#getReadWriteLock()} and all
 * read operations under the read lock from the same.
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 * <p>
 * Trying to add values that are not serializable will throw {@link NotSerializableRuntimeException}
 */
public interface ToolkitList<E> extends List<E>, ToolkitLockedObject, Destroyable {
  // no extra methods
}
