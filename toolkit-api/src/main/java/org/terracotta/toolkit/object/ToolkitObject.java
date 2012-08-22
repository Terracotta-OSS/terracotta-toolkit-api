/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.object;

import org.terracotta.toolkit.Toolkit;

/**
 * An instance retrieved/created using the {@link Toolkit}. Every instance created by the {@code Toolkit} is identified
 * by a {@linkplain #getName() name} and a {@linkplain #getType() type}.
 */
public interface ToolkitObject {
  /**
   * The name of this instance.
   * 
   * @return name which identifies this instance within its type
   */
  String getName();
}