/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
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
