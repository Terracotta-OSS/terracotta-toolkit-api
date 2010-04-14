package org.terracotta.express;

interface ClientFactoryInternal {
  public Client getOrCreateClient(String tcConfig, boolean isUrl);
}
