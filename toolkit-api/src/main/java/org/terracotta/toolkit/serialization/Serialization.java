/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.serialization;

import org.terracotta.toolkit.ToolkitFeature;

public interface Serialization extends ToolkitFeature {

  ToolkitSerializer getDefaultToolkitSerializer();

}
