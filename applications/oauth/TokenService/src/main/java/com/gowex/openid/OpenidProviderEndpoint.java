package com.gowex.openid;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.gowex.util.FileUtil;

@Path("/id={id}")
public class OpenidProviderEndpoint {

  private static String PATH_HTML_TEXT_OPENID =
    "/html/endpPointDefinition.html";

  @Context
  private UriInfo context;

  @Context
  private ServletContext servletContext;

  @GET
  @Produces("text/html")
  public String gethtml() {

    final String filePath =
      servletContext.getRealPath("") + PATH_HTML_TEXT_OPENID;

    return FileUtil.fromFileToString(filePath);
  }
}