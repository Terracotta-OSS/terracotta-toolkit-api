/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.attribute;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.Map;

public interface ToolkitAttributeExtractor {

  /**
   * Returns map of extracted attribute names to their values, for given key/value pair. If return value is
   * {@link #DO_NOT_INDEX}, skips this tuple from indexing
   */
  <K, V> Map<String, Object> attributesFor(K key, V value) throws ToolkitAttributeExtractorException;

  // fully qualified for checkstyle
  public static final org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor NULL_EXTRACTOR = new ToolkitAttributeExtractor() {

                                                                 @Override
                                                                 public <K, V> Map<String, Object> attributesFor(K key,
                                                                                                                 V value) {
                                                                   return Collections.emptyMap();
                                                                 }
                                                               };

  public static final Map                                                               DO_NOT_INDEX   = (Map) Proxy
                                                                                                           .newProxyInstance(Map.class
                                                                                                                                 .getClassLoader(),
                                                                                                                             new Class[] { Map.class },
                                                                                                                             new InvocationHandler() {

                                                                                                                               @Override
                                                                                                                               public Object invoke(Object proxy,
                                                                                                                                                    Method method,
                                                                                                                                                    Object[] args)
                                                                                                                                   throws Throwable {
                                                                                                                                 throw new UnsupportedOperationException(
                                                                                                                                                                         "Attempt to call method on special marker object");
                                                                                                                               }
                                                                                                                             });
}
