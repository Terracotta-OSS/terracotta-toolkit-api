/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
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
