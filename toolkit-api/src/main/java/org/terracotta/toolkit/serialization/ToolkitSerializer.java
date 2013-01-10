/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.serialization;

public interface ToolkitSerializer {

  <T> String serializeToString(T object);

  <T> T deserializeFromString(String serializedString);

  <T> T deserializeFromStringLocally(String serializedString);

}
