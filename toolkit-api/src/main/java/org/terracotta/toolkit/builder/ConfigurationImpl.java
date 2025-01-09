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
package org.terracotta.toolkit.builder;

import org.terracotta.toolkit.config.AbstractConfiguration;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ConfigurationImpl extends AbstractConfiguration {

  private final ConcurrentHashMap<String, Serializable> map = new ConcurrentHashMap<String, Serializable>();

  protected ConfigurationImpl() {
    //
  }

  @Override
  public Serializable getObjectOrNull(String name) {
    return map.get(name);
  }

  @Override
  public void internalSetConfigMapping(String name, Serializable value) {
    map.put(name, value);
  }

  @Override
  public Set<String> getKeys() {
    return this.map.keySet();
  }

  @Override
  public String toString() {
    return "ConfigurationImpl [" + this.map + "]";
  }
}
