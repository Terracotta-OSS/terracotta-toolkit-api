/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.config;

import java.io.Serializable;
import java.util.Set;

/**
 * A generic configuration object whose behavior is same as that of map but can store only literal values. The getters
 * of this class return the value only if the config contains a mapping for that name with the correct type. An
 * IllegalArgumentException is thrown otherwise.
 */
public interface Configuration {

  /**
   * Returns true if the config contains a mapping for specified name
   * 
   * @return true if the config contains a mapping for specified name, otherwise false
   */
  boolean hasField(String name);

  /**
   * Get a config for the {@code name} parameter.
   * 
   * @return an int value if and only if {@code name} is mapped to an int value
   * @throws IllegalArgumentException if no mapping exists with {@code name} or it exists but value is not of type int
   */
  int getInt(String name) throws IllegalArgumentException;

  /**
   * Get a config for the {@code name} parameter.
   * 
   * @return a long value if and only if {@code name} is mapped to a long value
   * @throws IllegalArgumentException if no mapping exists with {@code name} or it exists but value is not of type long
   */
  long getLong(String name) throws IllegalArgumentException;

  /**
   * Get a config for the {@code name} parameter.
   * 
   * @return a boolean value if and only if {@code name} is mapped to a boolean value
   * @throws IllegalArgumentException if no mapping exists with {@code name} or it exists but value is not of type
   *         boolean
   */
  boolean getBoolean(String name) throws IllegalArgumentException;

  /**
   * Get a config for the {@code name} parameter.
   * 
   * @return a string value if and only if {@code name} is mapped to a string value
   * @throws IllegalArgumentException if no mapping exists with {@code name} or it exists but value is not of type
   *         string
   */
  String getString(String name) throws IllegalArgumentException;

  /**
   * Gets the configuration field names present in this config instance
   * 
   * @return a set containing all mappings in this configuration object
   */
  Set<String> getKeys();

  /**
   * Gets the value for the configuration field name {@code name}
   * 
   * @return value mapped to {@code name} if present, otherwise null
   */
  Serializable getObjectOrNull(String name);
}
