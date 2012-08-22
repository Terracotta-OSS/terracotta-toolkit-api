/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.meta;

import java.util.Date;
import java.util.Map;

public interface MetaData {

  String getCategory();

  void add(String name, Object value);

  void add(String name, boolean value);

  void add(String name, byte value);

  void add(String name, char value);

  void add(String name, double value);

  void add(String name, float value);

  void add(String name, int value);

  void add(String name, long value);

  void add(String name, short value);

  void add(String name, String value);

  void add(String name, byte[] value);

  void add(String name, Enum value);

  void add(String name, Date value);

  void add(String name, java.sql.Date value);

  void set(String name, Object newValue);

  Map<String, Object> getMetaDatas();

}