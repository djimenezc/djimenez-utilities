package com.gowex.unitary.openid;

import org.junit.Test;

import com.gowex.openid.OpenidProviderEndpoint;

public class OpenidProviderEndpointTest {

  @Test
  public void testGetHtml() {

    final OpenidProviderEndpoint openidProviderEndpoint =
      new OpenidProviderEndpoint();

    final String html = openidProviderEndpoint.gethtml();

    org.junit.Assert.assertNotNull(html);
  }
}
