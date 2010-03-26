package es.dia.pos.n2a.util.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.djimenez.util.net.NetException;
import com.djimenez.util.net.NetInfo;
import com.djimenez.util.os.unix.NetInfoImpl;

public class NetInfoFedoraTest {

  // Test Files
  private final String NETWORK_FILE_TEST = "network-test";
  // Fichero temporal
  private File tempNetworkFile = null;

  // Clase a testear
  private NetInfo netInfo = null;

  @After
  public void finalizeTest() throws IOException {
    // Eliminamos el fichero temporal para pruebas
    this.tempNetworkFile.delete();
  }

  /**
   * Copia el fichero de test a /tmp/XXX.tmp para lanzar las pruebas sobre una
   * copia del mismo.
   */
  private File generateTestFile() throws IOException {

    final File tmpFile = File.createTempFile("test", ".tmp");

    // Extraemos de los trecursos para test el fichero de pruebas final
    final InputStream fin =
      NetInfoFedoraTest.class.getClassLoader().getResourceAsStream(
        this.NETWORK_FILE_TEST);

    // Generamos una copia con la que vamos a pasar las pruebas final
    final FileOutputStream fout = new FileOutputStream(tmpFile);

    final byte[] buffer = new byte[1024];

    int bytesRead;
    while ((bytesRead = fin.read(buffer)) > 0) {
      fout.write(buffer, 0, bytesRead);
    }

    fin.close();
    fout.close();

    return tmpFile;
  }

  @Before
  public void prepareTest() throws IOException {

    // Generamos un fichero temporal para pruebas
    this.tempNetworkFile = this.generateTestFile();

    // Informacion de Red para una distribucion Red-Hat - Fedora
    this.netInfo = new NetInfoImpl(this.tempNetworkFile.getAbsolutePath());
  }

  // ----------------------
  @Test
  public void testGetGateway() throws NetException {
    Assert.assertNotNull(this.netInfo.getGateWay());
  }

  // ----------------------
  @Test
  public void testGetHostName() throws NetException {
    Assert.assertNotNull(this.netInfo.getHostName());
  }

  @Test
  public void testSetHostName() throws NetException {
    final String dataTest = "spain25";

    this.netInfo.setHostName(dataTest);
    Assert.assertEquals(dataTest, this.netInfo.getHostName());
  }

  @Test
  public void testSetNotWellFormedGateway() {
    boolean result = false;

    final String dataTest = "3.4.5.J";
    try {
      this.netInfo.setGateWay(dataTest);
    }
    catch (final NetException e) {
      result = true;
    }
    Assert.assertEquals(result, true);
  }

  @Test
  public void testSetWellFormedGateway() throws NetException {
    final String dataTest = "3.4.5.6";

    this.netInfo.setGateWay(dataTest);
    Assert.assertEquals(dataTest, this.netInfo.getGateWay());
  }
}
