/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.events;

import org.terracotta.toolkit.tck.TCKStrict;

/**
 * A listener for {@link ToolkitNotifier}.
 */
@TCKStrict
public interface ToolkitNotificationListener<T> {
  /**
   * This method is called when a user implements this interface and attaches it to the ToolkitNotifier.
   * 
   * @param event the {@link ToolkitNotificationEvent} containing details of the event
   */
  void onNotification(ToolkitNotificationEvent<T> event);
}