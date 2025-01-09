/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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