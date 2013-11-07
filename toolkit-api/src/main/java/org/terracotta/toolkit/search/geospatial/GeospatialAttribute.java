/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.geospatial;

import org.terracotta.toolkit.search.Attribute;
import org.terracotta.toolkit.search.expression.Clause;
import org.terracotta.toolkit.search.expression.InRadiusClause;
import org.terracotta.toolkit.search.expression.InRectangeClause;

public class GeospatialAttribute<T> extends Attribute<T> {
  public GeospatialAttribute(String attributeName) {
    super(attributeName);
  }

  public Clause inRadius(LatLongCoordinate center, double distance) {
    return new InRadiusClause(getAttributeName(), center, distance);
  }

  public Clause inRectangle(LatLongCoordinate lowerLeft, LatLongCoordinate upperRight) {
    return new InRectangeClause(getAttributeName(), lowerLeft, upperRight);
  }

}
