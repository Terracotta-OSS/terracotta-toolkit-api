/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

/**
 * @author Alex Snaps
 */
public interface SecretProvider {

  public void fetchSecret();

  public byte[] getSecret();
}
