/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.tdk.signaturetest.ToolkitSignatureTest;
import com.sun.tdk.signaturetest.ToolkitSignatureTestConfig;

import java.io.File;

import junit.framework.Assert;

public class BackwardCompatibleTest {
  private static final String TOOLKIT_API_JAR     = "terracotta-toolkit-api.jar";
  private static final String DEFAULT_API_PACKAGE = "org.terracotta";
  private static final String jdkVersion          = System.getProperty("java.specification.version");
  private static String       javaRuntime;
  private static File         baseDir;

  private static File         toolkitApiJar;

  @BeforeClass
  public static void setup() throws Exception {
    javaRuntime = System.getProperty("java.home") + "/lib/rt.jar";
    if (System.getProperty("os.name").contains("Mac")) {
      javaRuntime = System.getProperty("java.home") + "/../Classes/classes.jar";
    }

    baseDir = new File(System.getProperty("basedir", ".")).getCanonicalFile();
    toolkitApiJar = new File(baseDir, "target" + File.separator + TOOLKIT_API_JAR);
    if (!toolkitApiJar.exists()) { throw new AssertionError("Toolkit jar not found: " + toolkitApiJar); }
  }

  private ToolkitSignatureTestConfig setupConfig(String apiVersion, File signatureFile) {
    ToolkitSignatureTestConfig config = new ToolkitSignatureTestConfig();
    config.classpath(javaRuntime + File.pathSeparator + toolkitApiJar).apiVersion(apiVersion)
        .backwardCompatibleTest(true).signatureFile(signatureFile.getAbsolutePath());
    return config;
  }

  @Test
  public void tckTest() throws Exception {
    String testedAPIVersion = System.getProperty("tested-api.version", "current");
    File signatureDir = new File(baseDir, "src/signatures");
    File[] apiDirs = signatureDir.listFiles();
    for (File apiDir : apiDirs) {
      if (apiDir.getName().equals(".svn")) continue;
      File signatureFile = new File(apiDir, "reference-" + jdkVersion + ".sig");
      if (!signatureFile.exists()) { throw new AssertionError("Signature file not found: " + signatureFile); }
      ToolkitSignatureTestConfig config = setupConfig(testedAPIVersion, signatureFile);
      config.packages(DEFAULT_API_PACKAGE);
      ToolkitSignatureTest tst = new ToolkitSignatureTest(config.getArguments());
      Assert.assertTrue(tst.run());
    }
  }
}
