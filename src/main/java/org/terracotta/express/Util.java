package org.terracotta.express;

class Util {

  private Util() {
    //
  }

  static <T> T getImplInstance(String type) {
    try {
      return (T) Class.forName(type).newInstance();
    } catch (Exception e) {
      if (e instanceof RuntimeException) { throw (RuntimeException) e; }
      throw new RuntimeException(e);
    }
  }

}
