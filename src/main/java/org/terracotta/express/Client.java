package org.terracotta.express;

public interface Client {
  <T> T instantiate(String className, Class[] cstrArgTypes, Object[] cstrArgs) throws Exception;

  <T> T staticFactoryMethod(String className, String methodName, Class[] argTypes, Object[] args) throws Exception;
  
  void shutdown();

  void introspectModules(Class source);

}
