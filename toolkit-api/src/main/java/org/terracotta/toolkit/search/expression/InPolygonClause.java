/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

import org.terracotta.toolkit.search.geospatial.LatLongCoordinate;

public class InPolygonClause extends BaseClause {
  private final String attributeName;
  private final LatLongCoordinate[] points;

  public InPolygonClause(String attributeName, LatLongCoordinate... points) {
    this.attributeName = attributeName;
    this.points = points;
  }

  public LatLongCoordinate[] getPoints() {
    return points;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getAttributeName()).append(SEP).append("InPolygonClause").append(SEP).append(points);
    return sb.toString();
  }

  public String getAttributeName() {
    return attributeName;
  }
}
