/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

import org.terracotta.toolkit.nonstop.NonStopConfiguration;
import org.terracotta.toolkit.nonstop.NonStopConfigurationRegistry;

public interface NonStopToolkit extends Toolkit {
  /**
   * 
   */
  void begin(NonStopConfiguration configuration);

  void finish();

  NonStopConfigurationRegistry getNonStopToolkitRegistry();
}
