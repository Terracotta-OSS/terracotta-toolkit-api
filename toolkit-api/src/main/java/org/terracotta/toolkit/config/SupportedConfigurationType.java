/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.config;

import org.terracotta.toolkit.tck.TCKStrict;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@TCKStrict
public enum SupportedConfigurationType {
  INTEGER(Integer.class) {

    @Override
    public <T> Integer getFromConfig(Configuration config, String name) {
      return Integer.valueOf(config.getInt(name));
    }
  },
  BOOLEAN(Boolean.class) {

    @Override
    public <T> Boolean getFromConfig(Configuration config, String name) {
      return Boolean.valueOf(config.getBoolean(name));
    }

  },
  STRING(String.class) {

    @Override
    public <T> String getFromConfig(Configuration config, String name) {
      return config.getString(name);
    }

  },
  LONG(Long.class) {

    @Override
    public <T> Long getFromConfig(Configuration config, String name) {
      return Long.valueOf(config.getLong(name));
    }

    @Override
    public boolean isSupported(SupportedConfigurationType other) {
      return this == other || other == INTEGER;
    }
  };

  private static final Map<Class, SupportedConfigurationType> SUPPORTED_TYPES;
  static {
    HashMap<Class, SupportedConfigurationType> tmp = new HashMap<Class, SupportedConfigurationType>();
    for (SupportedConfigurationType type : SupportedConfigurationType.values()) {
      tmp.put(type.classType, type);
    }
    SUPPORTED_TYPES = tmp;
  }

  /**
   * Returns the corresponding {@link SupportedConfigurationType} for the object or throws exception if not supported
   */
  public static SupportedConfigurationType getTypeForObject(Object obj) {
    if (obj == null) { throw new NullPointerException("Object cannot be null"); }
    SupportedConfigurationType configType = SUPPORTED_TYPES.get(obj.getClass());
    if (configType == null) {
      throw new RuntimeException("Unsupported type of object - class: " + obj.getClass().getName() + ", value: " + obj);
    } else {
      return configType;
    }
  }

  /**
   * Returns the corresponding {@link SupportedConfigurationType} for the object or returns null if not supported
   */
  public static boolean isTypeSupported(Object obj) {
    if (obj == null) { return false; }
    return SUPPORTED_TYPES.get(obj.getClass()) != null;
  }

  public static SupportedConfigurationType getTypeForObjectOrNull(Object obj) {
    if (obj == null) return null;
    return SUPPORTED_TYPES.get(obj.getClass());
  }

  private final Class classType;

  private SupportedConfigurationType(Class classType) {
    this.classType = classType;
  }

  public abstract <T> Serializable getFromConfig(Configuration config, String name);

  public boolean isSupported(SupportedConfigurationType other) {
    return this == other;
  }

}
