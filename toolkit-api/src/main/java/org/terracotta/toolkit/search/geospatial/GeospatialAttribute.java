/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.geospatial;

import org.terracotta.toolkit.search.expression.Clause;
import org.terracotta.toolkit.search.expression.InRadiusClause;
import org.terracotta.toolkit.search.expression.InRectangeClause;

public class GeospatialAttribute {
  private final String attributeName;
  public GeospatialAttribute(String attributeName) {
    this.attributeName = attributeName;
  }

  public Clause inRadius(LatLongCoordinate center, double distance) {
    return new InRadiusClause(attributeName, center, distance);
  }

  public Clause inRectangle(LatLongCoordinate lowerLeft, LatLongCoordinate upperRight) {
    return new InRectangeClause(attributeName, lowerLeft, upperRight);
  }

}
