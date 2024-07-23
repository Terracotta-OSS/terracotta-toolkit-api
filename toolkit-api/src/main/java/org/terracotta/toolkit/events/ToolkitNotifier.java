/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.events;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitObject;

import java.util.List;

/**
 * A notifier that can be used to send notifications across the cluster.
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 */
public interface ToolkitNotifier<T> extends Destroyable, ToolkitObject {
  /**
   * Add a local notification listener. Will be notified for remote changes.
   */
  void addNotificationListener(ToolkitNotificationListener<T> listener);

  /**
   * Remove the notification listener.
   */
  void removeNotificationListener(ToolkitNotificationListener<T> listener);

  /**
   * Send the msg to all the listeners in the cluster<br>
   * The local listeners wont be notified
   */
  void notifyListeners(T msg);

  /**
   * Returns the List of the local NotificationListeners. The returned list is not mutable.
   * 
   * @return list of listeners
   */
  List<ToolkitNotificationListener<T>> getNotificationListeners();
}