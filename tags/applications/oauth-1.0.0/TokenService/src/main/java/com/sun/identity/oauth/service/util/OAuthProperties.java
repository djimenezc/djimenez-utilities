/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER. Copyright (c) 2009
 * Sun Microsystems Inc. All Rights Reserved The contents of this file are
 * subject to the terms of the Common Development and Distribution License (the
 * License). You may not use this file except in compliance with the License.
 * You can obtain a copy of the License at
 * https://opensso.dev.java.net/public/CDDLv1.0.html or
 * opensso/legal/CDDLv1.0.txt See the License for the specific language
 * governing permission and limitations under the License. When distributing
 * Covered Code, include this CDDL Header Notice in each file and include the
 * License file at opensso/legal/CDDLv1.0.txt. If applicable, add the following
 * below the CDDL Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]" $Id:
 * OAuthProperties.java,v 1.1 2009-11-20 19:31:58 huacui Exp $
 */

package com.sun.identity.oauth.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.identity.oauth.service.PathDefs;
import com.sun.identity.shared.Constants;
import com.sun.identity.shared.configuration.SystemPropertiesManager;

/**
 * Gets configuration data from <code>OAuthConfig.properties</code>.
 */
public class OAuthProperties {

  private static Properties props;
  private static String serverMode;
  private static final String PROPFILE_NAME = "OAuthConfig.properties";

  static {
    initProperties();
  }

  public static String get(final String key) {
    String value = null;
    if (key != null) {
      value = (String) props.get(key);
    }
    return value;
  }

  private static void initProperties() {

    props = new Properties();
    try {
      final ClassLoader cl = OAuthProperties.class.getClassLoader();
      final InputStream is = cl.getResourceAsStream("/config/" + PROPFILE_NAME);
      props.load(is);

      // Use the opensso hosted URL if the OAuth service is
      // embedded with the opensso server
      final String protocol =
        SystemPropertiesManager.get(Constants.AM_SERVER_PROTOCOL);
      final String host = SystemPropertiesManager.get(Constants.AM_SERVER_HOST);
      final String port = SystemPropertiesManager.get(Constants.AM_SERVER_PORT);
      final String deployURI =
        SystemPropertiesManager
          .get(Constants.AM_SERVICES_DEPLOYMENT_DESCRIPTOR);
      String openssoURL = null;
      if ((protocol != null) && (protocol.trim().length() > 0)
        && (host != null) && (host.trim().length() > 0)) {
        openssoURL = protocol + "://" + host;
        if ((port != null) && (port.trim().length() > 0)) {
          openssoURL += ":" + port;
        }
      }
      if (openssoURL != null) {
        if ((deployURI != null) && (deployURI.trim().length() > 0)) {
          if (!deployURI.startsWith("/")) {
            openssoURL += "/";
          }
          openssoURL += deployURI;
        }
      }
      final String openssoCookie =
        SystemPropertiesManager.get(Constants.AM_COOKIE_NAME);

      if (openssoURL != null) {
        props.setProperty(PathDefs.OPENSSO_SERVER_URL, openssoURL);
      }
      if (openssoCookie != null) {
        props.setProperty(PathDefs.OPENSSO_COOKIE_NAME, openssoCookie);
      }
      serverMode = SystemPropertiesManager.get(Constants.SERVER_MODE);
    }
    catch (final IOException ie) {
      Logger.getLogger(OAuthProperties.class.getName()).log(Level.SEVERE, null,
        ie);
    }
  }

  public static boolean isServerMode() {
    boolean isServerMode = false;
    if ((serverMode != null) && serverMode.equalsIgnoreCase("true")) {
      isServerMode = true;
    }
    return isServerMode;
  }

  private OAuthProperties() {
  }
}
