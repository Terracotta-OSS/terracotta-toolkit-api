package org.terracotta.properties;

public interface TerracottaProperties {

  int getInt(String key);

  int getInt(String key, int defaultValue);

  long getLong(String key);
  
  long getLong(String key, long defaultValue);

  boolean getBoolean(String key);

  boolean getBoolean(String key, boolean defaultValue);

  String getProperty(String key);

  String getProperty(String key, boolean missingOkay);

  float getFloat(String key);
}