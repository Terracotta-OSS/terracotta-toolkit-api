/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.attribute;

import org.terracotta.toolkit.search.SearchException;

import java.io.Serializable;

public class ToolkitAttributeExtractorException extends SearchException implements Serializable {
  private static final long serialVersionUID = 8924836209375321094L;

  public ToolkitAttributeExtractorException(Throwable cause) {
    super(cause);
  }

  public ToolkitAttributeExtractorException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public ToolkitAttributeExtractorException(String msg) {
    super(msg);
  }

}
