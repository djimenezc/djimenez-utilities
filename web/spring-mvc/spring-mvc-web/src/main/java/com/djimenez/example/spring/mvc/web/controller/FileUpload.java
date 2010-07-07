package com.djimenez.example.spring.mvc.web.controller;

/**
 * Command class to handle uploading of a file.
 * <p>
 * <a href="FileUpload.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class FileUpload {

  private String name;
  private byte[] file;

  public byte[] getFile() {
    return file;
  }

  /**
   * @return Returns the name.
   */
  public String getName() {
    return name;
  }

  public void setFile(final byte[] file) {
    this.file = file;
  }

  /**
   * @param name
   *          The name to set.
   */
  public void setName(final String name) {
    this.name = name;
  }
}