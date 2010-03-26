package org.terracotta.api;

public class Clustering {

  private static final ClusteringProvider INSTANCE;

  static {
    try {
      INSTANCE = (ClusteringProvider) Class.forName("org.terracotta.api.ClusteringProviderImpl").newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static ClusteringProvider provider() {
    return INSTANCE;
  }
}