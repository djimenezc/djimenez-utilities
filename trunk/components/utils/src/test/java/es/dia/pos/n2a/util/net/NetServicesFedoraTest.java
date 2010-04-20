package es.dia.pos.n2a.util.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.djimenez.util.constants.GeneralConstants;
import com.djimenez.util.net.NetException;
import com.djimenez.util.os.unix.NetServicesImpl;

public class NetServicesFedoraTest {

  // Test Files
  private static final String IFCFG_ETH0_FILE = "ifcfg-eth0-test";
  // Fichero temporal
  private File tempEth0File = null;

  // Clase a testear
  private NetServicesImpl netServices = null;

  @After
  public final void finalizeTest() throws IOException {
    // Eliminamos el fichero temporal para pruebas
    if (!this.tempEth0File.delete()) {

      throw new IOException();
    }
  }

  /**
   * Copia el fichero de test a /tmp/XX.tmp para lanzar las pruebas sobre una
   * copia del mismo.
   */
  private File generateTestFile() throws IOException {

    final File tmpFile = File.createTempFile("test", ".tmp");

    // Extraemos de los trecursos para test el fichero de pruebas final
    final InputStream fin =
      NetServicesFedoraTest.class.getClassLoader().getResourceAsStream(
        IFCFG_ETH0_FILE);

    // Generamos una copia con la que vamos a pasar las pruebas final
    final FileOutputStream fout = new FileOutputStream(tmpFile);

    final byte[] buffer = new byte[GeneralConstants.BYTE_FACTOR];

    int bytesRead;
    while ((bytesRead = fin.read(buffer)) > 0) {
      fout.write(buffer, 0, bytesRead);
    }

    fin.close();
    fout.close();

    return tmpFile;
  }

  @Before
  public final void prepareTest() throws IOException {

    // Generamos un fichero temporal para pruebas
    this.tempEth0File = this.generateTestFile();

    // Informacion de Red para una distribucion Red-Hat - Fedora
    this.netServices = new NetServicesImpl(this.tempEth0File.getAbsolutePath());
  }

  // ----------------------

  // ----------------------
  @Test
  public final void testGetBroadCastIP() throws NetException {
    Assert.assertNotNull(this.netServices.getBroadCast());
  }

  @Test
  public final void testGetIPaddr() throws NetException {
    Assert.assertNotNull(this.netServices.getIPaddr());
  }

  // ----------------------
  @Test
  public final void testGetNetMask() throws NetException {
    Assert.assertNotNull(this.netServices.getNetMask());
  }

  // ----------------------
  @Test
  public final void testGetNetworkIP() throws NetException {
    Assert.assertNotNull(this.netServices.getNetwork());
  }

  @Test
  public final void testSetNotWellFormedBroadCastIP() {
    boolean result = false;

    final String dataTest = "3.4.5.J";
    try {
      this.netServices.setBroadCast(dataTest);
    }
    catch (final NetException e) {
      result = true;
    }
    Assert.assertEquals(result, true);
  }

  @Test
  public final void testSetNotWellFormedIPaddr() {
    boolean result = false;

    final String dataTest = "3.4.5.J";
    try {
      this.netServices.setIPaddr(dataTest);
    }
    catch (final NetException e) {
      result = true;
    }
    Assert.assertEquals(result, true);
  }

  @Test
  public final void testSetNotWellFormedNetMask() {
    boolean result = false;

    final String dataTest = "3.4.5.J";
    try {
      this.netServices.setNetMask(dataTest);
    }
    catch (final NetException e) {
      result = true;
    }
    Assert.assertEquals(result, true);
  }

  @Test
  public final void testSetNotWellFormedNetWorkIP() {
    boolean result = false;

    final String dataTest = "3.4.5.J";
    try {
      this.netServices.setNetwork(dataTest);
    }
    catch (final NetException e) {
      result = true;
    }
    Assert.assertEquals(result, true);
  }

  @Test
  public final void testSetWellFormedBroadCastIP() throws NetException {
    final String dataTest = "3.4.5.6";

    this.netServices.setBroadCast(dataTest);
    Assert.assertEquals(dataTest, this.netServices.getBroadCast());
  }

  @Test
  public final void testSetWellFormedIPaddr() throws NetException {
    final String dataTest = "3.4.5.6";

    this.netServices.setIPaddr(dataTest);
    Assert.assertEquals(dataTest, this.netServices.getIPaddr());
  }

  @Test
  public final void testSetWellFormedNetMask() throws NetException {
    final String dataTest = "3.4.5.6";

    this.netServices.setNetMask(dataTest);
    Assert.assertEquals(dataTest, this.netServices.getNetMask());
  }

  @Test
  public final void testSetWellFormedNetWorkIP() throws NetException {
    final String dataTest = "3.4.5.6";

    this.netServices.setNetwork(dataTest);
    Assert.assertEquals(dataTest, this.netServices.getNetwork());
  }
}