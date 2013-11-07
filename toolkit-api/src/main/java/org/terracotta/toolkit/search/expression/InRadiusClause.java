/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

import org.terracotta.toolkit.search.geospatial.LatLongCoordinate;

public class InRadiusClause extends BaseClause {
  private final String attributeName;
  private final LatLongCoordinate center;
  private final double            distance;

  public InRadiusClause(String attributeName, LatLongCoordinate center, double distance) {
    this.attributeName = attributeName;
    this.center = center;
    this.distance = distance;
  }

  public LatLongCoordinate getCenter() {
    return center;
  }

  public double getDistance() {
    return distance;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getAttributeName()).append(SEP).append("InRadius").append(SEP).append(center).append(SEP)
        .append(distance);
    return sb.toString();
  }

  public String getAttributeName() {
    return attributeName;
  }
}
