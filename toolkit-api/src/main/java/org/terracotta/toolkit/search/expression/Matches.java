/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

import org.terracotta.toolkit.search.SearchException;

public class Matches extends BaseClause {

  private final String attributeName;
  private final String regex;

  /**
   * Construct a "like" criteria for the given expression. Expressions are <b>always case insensitive</b><br>
   * <br>
   * The following special characters are supported:<br>
   * <ul>
   * <li>'?' - match any one single character
   * <li>'*' - match any multiple character(s) (including zero)
   * </ul>
   * The supported wildcard characters can be escaped with a backslash '\', and a literal backslash can be included with
   * '\\'<br>
   * <br>
   * WARN: Expressions starting with a leading wildcard character are potentially very expensive (ie. full scan) for
   * indexed caches
   * <p/>
   * 
   * @param attributeName attribute name
   * @param regex expression
   */
  public Matches(String attributeName, String regex) {
    if (attributeName == null || regex == null) { throw new SearchException(
                                                                            "Both attribute name and regex must be non null."); }

    this.attributeName = attributeName;
    this.regex = regex;
  }

  public String getRegex() {
    return regex;
  }

  public String getAttributeName() {
    return attributeName;
  }

}
