/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.feature;

import org.terracotta.toolkit.ToolkitFeature;
import org.terracotta.toolkit.serialization.ToolkitSerializer;

/**
 * Serialization feature
 */
public interface SerializationFeature extends ToolkitFeature {

  /**
   * Returns the default {@link ToolkitSerializer} associated with the toolkit. This can throw
   * {@link FeatureNotSupportedException} if the toolkit runtime doesn't support this feature.
   * 
   * @return the default {@link ToolkitSerializer} associated with the toolkit
   */
  ToolkitSerializer getDefaultToolkitSerializer() throws FeatureNotSupportedException;

}
