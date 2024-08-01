/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.object;

import org.terracotta.toolkit.Toolkit;

/**
 * An instance retrieved/created using the {@link Toolkit}. Every instance created by the {@code Toolkit} is identified
 * by a {@linkplain #getName() name}.
 */
public interface ToolkitObject {
  /**
   * The name of this instance.
   * 
   * @return name which identifies this instance within its type
   */
  String getName();
}