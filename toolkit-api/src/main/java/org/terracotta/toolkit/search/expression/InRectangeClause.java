/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

import org.terracotta.toolkit.search.geospatial.LatLongCoordinate;

public class InRectangeClause extends BaseClause {
  private final String attributeName;
  private final LatLongCoordinate lowerLeft;
  private final LatLongCoordinate upperRight;

  public InRectangeClause(String attributeName, LatLongCoordinate lowerLeft, LatLongCoordinate upperRight) {
    this.attributeName = attributeName;
    this.lowerLeft = lowerLeft;
    this.upperRight = upperRight;
  }

  public LatLongCoordinate getLowerLeft() {
    return lowerLeft;
  }

  public LatLongCoordinate getUpperRight() {
    return upperRight;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getAttributeName()).append(SEP).append("InRadius").append(SEP).append(lowerLeft).append(SEP)
        .append(upperRight);
    return sb.toString();
  }

  public String getAttributeName() {
    return attributeName;
  }
}
