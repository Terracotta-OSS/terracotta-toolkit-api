/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.nonstop.NonStopConfigFields.NonStopToolkitType;

public interface NonStopConfigRegistry {
  void registerForToolkitType(NonStopConfig config, NonStopToolkitType... types);

  void register(NonStopConfig config, String namePatternRegex, String methodPatternRegex, NonStopToolkitType... types);

  NonStopConfig getConfig(NonStopToolkitType type, String name, String methodPatternRegex);

  NonStopConfig unregisterForToolkitType(NonStopConfig config, NonStopToolkitType... types);

  NonStopConfig unregister(NonStopConfig config, String name, String methodPatternRegex, NonStopToolkitType... types);
}
