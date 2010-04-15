package com.djimenez.util.os.configuration.files.types;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.ini4j.Ini;
import org.ini4j.Wini;

import com.djimenez.util.os.configuration.files.validators.Validator;

/**
 * Wrapper for system file Windows - INI format. Example files : dcs.ini
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class INIFileHelper {

  // Logger
  // private static final Logger logger = Logger.getLogger(INIFileHelper.class);

  // Path properties file.
  private String pathFile = null;
  // Properties JAVA Standard API
  private Wini iniFile = null;
  // Caracter por defecto para asignar a los comentarios
  private char characterComment = '#';

  public final char getCharacterComment() {
    return this.characterComment;
  }

  //
  // Getters and Setters
  //
  public final String getPathFile() {
    return this.pathFile;
  }

  /**
   * Return the value for the key passed in system config file in properties
   * file format.
   * 
   * @param key
   *          The key.
   * @return The value of the key or null is key not exist
   * @throws IOException
   *           On loading file error.
   */
  public final String getProperty(final String section, final String key)
    throws IOException {

    this.load();

    String value = null;
    final Ini.Section sec = this.iniFile.get(section);
    if (sec != null) {
      value = sec.get(key);
    }
    return value;
  }

  /**
   * Load the properties file
   * 
   * @throws IOException
   */
  private void load() throws IOException {
    this.iniFile = new Wini(new File(this.pathFile));
  }

  public final void setCharacterComment(final char characterComment) {
    this.characterComment = characterComment;
  }

  public final void setPathFile(final String pathFile) {
    this.pathFile = pathFile;
  }

  /**
   * Set a property in system config file in properties file format. The key is
   * added if not exits in file.
   * 
   * @param section
   *          Section in INI file
   * @param key
   *          Property
   * @param value
   *          Value of property
   * @param comment
   *          Add a comment before the generated comment with modification date.
   *          If null, no comment is added before the modification date.
   * @throws IOException
   *           On storing file error or validation error
   */
  public final void setProperty(final String section, final String key,
    final String value, final String comment) throws IOException {

    this.load();

    final Ini.Section sec = this.iniFile.get(section);
    if (sec != null) {
      sec.put(key, value);
    }

    if (comment != null) {
      this.store(comment);
    }
    else {
      this.store("");
    }
  }

  /**
   * Set a property in system config file in properties file format. The key is
   * added if not exits in file.
   * 
   * @param validator
   *          Validate the value param
   * @param key
   *          Property
   * @param value
   *          Value of property
   * @param comment
   *          Add a comment before the generated comment with modification date.
   *          If null, no comment is added before the modification date.
   * @throws IOException
   *           On storing file error or validation error
   */
  public final void setProperty(final Validator<String> validator,
    final String section, final String key, final String value,
    final String comment) throws IOException {

    if (validator.validate(value)) {
      this.setProperty(section, key, value, comment);
    }
    else {
      throw new IOException(validator.getErrorMesg());
    }
  }

  /**
   * Store the properties file.
   * 
   * @param comments
   * @throws IOException
   */
  private void store(final String comments) throws IOException {
    FileOutputStream output = null;

    output = new FileOutputStream(this.pathFile);

    // Comentarios
    if (null != comments) {
      this.writeToFile(output, comments);
    }

    // Fecha de modificacion
    this.writeModificationDateToFile(output);

    this.iniFile.store(output);

  }

  private void writeModificationDateToFile(final FileOutputStream out)
    throws IOException {
    final Date modificationDate = new Date();

    out.write(this.getCharacterComment());
    out.write(modificationDate.toString().getBytes());
    out.write(System.getProperty("line.separator").getBytes());
  }

  private void writeToFile(final FileOutputStream out, final String cadena)
    throws IOException {

    final String[] lines = cadena.split(System.getProperty("line.separator"));

    for (final String line : lines) {
      out.write(this.getCharacterComment());
      out.write(line.getBytes());
      out.write(System.getProperty("line.separator").getBytes());
    }
  }

}
