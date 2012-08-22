/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.tck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for TCK - interfaces or classes annotated with this annotation will be checked for backward
 * compatibility between minor releases by TCK. Interfaces that are meant to be implemented by users should be annotated
 * with this annotation. Typically event callback interfaces, listener interfaces, enums etc should be marked with this
 * annotation as those interface are supposed to be implemented by toolkit users.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TCKStrict {
  //
}
