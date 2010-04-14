package org.terracotta.express;

public class ClientFactory {

  private static final ClientFactoryInternal INSTANCE;

  static {
    // XXX: The name of this class could maybe be configurable
    INSTANCE = Util.getImplInstance("org.terracotta.express.ClientFactoryImpl");
  }

  // XXX: takes more args (ie. module URL(s))
  public static Client getOrCreateClient(String tcConfig, boolean isUrl) {
    return INSTANCE.getOrCreateClient(tcConfig, isUrl);
  }

}
