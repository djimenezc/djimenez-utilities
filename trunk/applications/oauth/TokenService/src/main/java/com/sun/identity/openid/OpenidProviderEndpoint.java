package com.sun.identity.openid;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/id={id}")
public class OpenidProviderEndpoint {

  @Context
  private UriInfo context;

  public String standard_profile =
  // "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
    // + "<!DOCTYPE html PUBLIC\"-//W3C//DTD XHTML 1.0 Transitional//EN\""
    // + "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\" >\n"
    // "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
    "<html>\n"
      + " <head>\n"
      // +
      // " <link rel=\"openid.server\" href=\"http://openid.example.com:10001/TokenService/openidOp/service\"/>\n"
      + " <link rel=\"openid2.provider\" href=\"http://localhost:10001/TokenService/openid/provider\"/>\n"
      + " <link rel=\"openid.server\" href=\"http://localhost:10001/TokenService/openid/provider\"/>\n"
      + " <link rel=\"openid.ns\" href=\"http://specs.openid.net/auth/2.0\"/>\n"
      // +
      // " <link rel=\"openid2.provider\" href=\"http://localhost:10001/TokenService/openid/provider\"/>\n"
      + " <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n"
      + " <title>Gowex OpenID provider</title>\n"
      + " <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n"
      + " </head>\n"
      + " <body>\n"
      + " <div class=\"body\">\n"
      + " <h2>This OpenID provider is based upon OpenID4Java & supports the following protocols</h2>\n"
      + " <UL>\n"
      + " <li>OpenID Authentication 2.0</li>\n"
      + " <li>OpenID Authentication 1.1 (in compatibility mode)</li>\n"
      + " <li>OpenID Attribute Exchange 1.0</li>\n"
      + " <li>OpenID Simple Registration 1.0 and 1.1, draft 1</li>\n"
      + " </UL>\n"
      + " </div>\n"
      + " <h2> To see the OpenID ID, view the source of this html page (usually achieved by right-clicking on the page)</h2>"
      + " <div>\n" + " </div>\n" + " </body>\n" + "</html>\n";

  @GET
  @Produces("text/html")
  public String gethtml() {

    return standard_profile;
  }
}