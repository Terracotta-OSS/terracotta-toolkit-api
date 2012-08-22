/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.config;

import java.io.Serializable;

public abstract class AbstractConfiguration implements Configuration {

  public Configuration setObject(String name, Serializable newValue) {
    setMappingChecked(name, newValue);
    return this;
  }

  public Configuration setInt(String name, int newValue) {
    setMappingChecked(name, Integer.valueOf(newValue));
    return this;
  }

  public Configuration setLong(String name, long newValue) {
    setMappingChecked(name, Long.valueOf(newValue));
    return this;
  }

  public Configuration setBoolean(String name, boolean newValue) {
    setMappingChecked(name, Boolean.valueOf(newValue));
    return this;
  }

  public Configuration setString(String name, String newValue) {
    setMappingChecked(name, newValue);
    return this;
  }

  @Override
  public boolean hasField(String name) {
    return getObjectOrNull(name) != null;
  }

  protected Object getMappingChecked(String name) {
    Object obj = getObjectOrNull(name);
    if (obj == null) {
      //
      throw new IllegalArgumentException("Configuration does not contain any mappings with name '" + name + "'");
    }
    if (SupportedConfigurationType.isTypeSupported(obj)) {
      // supported type
      return obj;
    } else {
      throw new IllegalArgumentException("Configuration mapping for name '" + name + "' exists, but is of type: "
                                         + obj.getClass().getName() + " which is not supported, with value: " + obj);
    }
  }

  private void setMappingChecked(String name, Serializable value) {
    if (value == null) { throw new NullPointerException("Value cannot be null"); }
    if (SupportedConfigurationType.isTypeSupported(value)) {
      internalSetConfigMapping(name, value);
    } else {
      throw new IllegalArgumentException("Configuration doesn't support type: " + value.getClass().getName()
                                         + ", value: " + value);
    }
  }

  @Override
  public int getInt(String name) {
    return getNumber(name).intValue();
  }

  @Override
  public long getLong(String name) {
    return getNumber(name).longValue();
  }

  private Number getNumber(String name) {
    return (Number) getMappingChecked(name);
  }

  @Override
  public boolean getBoolean(String name) {
    return (Boolean) getMappingChecked(name);
  }

  @Override
  public String getString(String name) {
    return (String) getMappingChecked(name);
  }

  protected abstract void internalSetConfigMapping(String key, Serializable value);

}
