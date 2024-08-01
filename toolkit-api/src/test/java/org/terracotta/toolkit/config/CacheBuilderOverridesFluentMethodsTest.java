/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
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
package org.terracotta.toolkit.config;

import org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder;
import org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test to make sure all fluent-style methods in {@link ToolkitStoreConfigBuilder} is overridden in
 * {@link ToolkitCacheConfigBuilder} but return type scoped down to {@link ToolkitCacheConfigBuilder}
 */
public class CacheBuilderOverridesFluentMethodsTest extends TestCase {

  public void test() {
    Set<String> fluentMethods = new HashSet<String>();
    Class klass = ToolkitStoreConfigBuilder.class;
    System.out.println("Fluent apis for class: " + klass.getName());
    for (Method m : klass.getDeclaredMethods()) {
      if (m.getReturnType().equals(ToolkitStoreConfigBuilder.class)) {
        String signature = getMethodSigWithoutReturnType(m);
        System.out.println("method: " + klass.getSimpleName() + " " + signature);
        fluentMethods.add(signature);
      }
    }

    klass = ToolkitCacheConfigBuilder.class;
    System.out.println("\nFluent apis for class: " + klass.getName());
    for (Method m : klass.getDeclaredMethods()) {
      if (m.getReturnType().equals(klass)) {
        String signature = getMethodSigWithoutReturnType(m);
        System.out.println("method: " + klass.getSimpleName() + " " + signature);
        fluentMethods.remove(signature);
      }
    }

    Assert.assertEquals("The following methods should be redeclared in "
                            + ToolkitCacheConfigBuilder.class.getSimpleName() + ", and return type should be "
                            + ToolkitCacheConfigBuilder.class.getSimpleName() + ":\n" + fluentMethods, 0,
                        fluentMethods.size());
  }

  private String getMethodSigWithoutReturnType(Method m) {
    StringBuilder sb = new StringBuilder();
    sb.append(m.getName()).append("(");
    for (Class type : m.getParameterTypes()) {
      sb.append(type.getName()).append(", ");
    }
    sb.delete(sb.toString().length() - 2, sb.toString().length() + 2);
    sb.append(");");
    return sb.toString();
  }
}
