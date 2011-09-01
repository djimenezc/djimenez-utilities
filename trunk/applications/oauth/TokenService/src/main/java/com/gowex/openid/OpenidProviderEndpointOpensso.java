package com.gowex.openid;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.gowex.util.FileUtil;

@Path("/openid/opensso/id={id}")
public class OpenidProviderEndpointOpensso {

  private static String PATH_HTML_TEXT_OPENID =
    "/html/endpPointDefinitionOpensso.html";

  @Context
  private UriInfo context;

  @GET
  @Produces("text/html")
  public String gethtml() {

    final String filePath =
      System.getProperty("user.dir") + PATH_HTML_TEXT_OPENID;

    return FileUtil.fromFileToString(filePath);
  }
}