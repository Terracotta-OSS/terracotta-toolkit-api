package org.terracotta.express;

public interface Client {
  <T> T instantiate(String className, Class[] cstrArgTypes, Object[] cstrArgs) throws Exception;

  void shutdown();

  void introspectModules(Class source);

}
