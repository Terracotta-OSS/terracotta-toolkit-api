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
package org.terracotta.toolkit.object.serialization;

import org.terracotta.toolkit.ToolkitRuntimeException;

/**
 * A runtime exception that is thrown when objects cannot be serialized. Its similar to java.io.NotSerializableException
 * in intent, but is an unchecked exception.
 */
public class NotSerializableRuntimeException extends ToolkitRuntimeException {

  public NotSerializableRuntimeException() {
    super();
  }

  public NotSerializableRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotSerializableRuntimeException(String message) {
    super(message);
  }

  public NotSerializableRuntimeException(Throwable cause) {
    super(cause);
  }

}
