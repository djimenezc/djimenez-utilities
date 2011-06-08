package com.gowex.openid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/id={id}")
public class OpenidProviderEndpoint {

  private static String PATH_HTML_TEXT_OPENID =
    "./src/main/webapp/html/endpPointDefinition.html";

  @Context
  private UriInfo context;

  @GET
  @Produces("text/html")
  public String gethtml() {

    BufferedReader reader;
    String line = null;
    final StringBuffer stringBuffer = new StringBuffer();

    try {
      reader = new BufferedReader(new FileReader(PATH_HTML_TEXT_OPENID));

      line = reader.readLine();

      while (line != null) {
        stringBuffer.append(line);
        stringBuffer.append(System.getProperty("line.separator"));
        line = reader.readLine();
      }
    }
    catch (final FileNotFoundException e1) {
      e1.printStackTrace();
    }
    catch (final IOException e) {
      e.printStackTrace();
    }

    return stringBuffer.toString();
  }
}