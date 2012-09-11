/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.attribute;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public interface ToolkitAttributeExtractor extends Serializable {

  <K, V> Map<String, Object> attributesFor(K key, V value) throws ToolkitAttributeExtractorException;

  // fully qualified for checkstyle
  public static final org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor NULL_EXTRACTOR = new ToolkitAttributeExtractor() {

                                                                 @Override
                                                                 public <K, V> Map<String, Object> attributesFor(K key,
                                                                                                                 V value) {
                                                                   return Collections.emptyMap();
                                                                 }
                                                               };
}
