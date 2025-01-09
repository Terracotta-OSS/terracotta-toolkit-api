/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.toolkit.search.attribute;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public interface ToolkitAttributeExtractor<K, V> {

  /**
   * Returns map of extracted attribute names to their values, for given key/value pair. If return value is
   * {@link #DO_NOT_INDEX}, skips this tuple from indexing
   */
  Map<String, Object> attributesFor(K key, V value) throws ToolkitAttributeExtractorException;

  // fully qualified for checkstyle
  public static final org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor NULL_EXTRACTOR = new NullAttributeExtractor();

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
