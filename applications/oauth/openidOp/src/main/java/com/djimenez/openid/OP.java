package com.djimenez.openid;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 * 
 * @author Hubert A. Le Van Gong <hubert.levangong at Sun.COM>
 */

@Path("/{id}")
public class OP {

  @Context
  private UriInfo context;

  String standard_profile =
    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
      + "<!DOCTYPE html PUBLIC\"-//W3C//DTD XHTML 1.0 Transitional//EN\""
      + "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\" >\n"
      + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
      + " <head>\n"
      + " <link rel=\"openid.server\" href=\"http://openid.example.com:49723/openid/service\"/>\n"
      + " <link rel=\"openid2.provider\" href=\"http://openid.example.com:49723/openid/service\"/>\n"
      + " <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n"
      + " <title>OpenSSO OpenID provider</title>\n"
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

  /** Creates a new instance of OP */
  public OP() {
  }

  /**
   * Retrieves representation of an instance of OP
   * 
   * @return an instance of java.lang.String
   */
  @GET
  @Produces("text/html")
  public String gethtml() {
    return standard_profile;
  }
}