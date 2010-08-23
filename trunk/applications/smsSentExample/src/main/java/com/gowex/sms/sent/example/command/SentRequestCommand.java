package com.gowex.sms.sent.example.command;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import com.gowex.http.AbstractHttpCommand;

public class SentRequestCommand extends AbstractHttpCommand {

  private static final String CONTENT_TYPE =
    "application/x-www-form-urlencoded; charset=UTF-8";
  private static final String URL_SENT_SMS = "http://www.altiria.net/api/http";

  public SentRequestCommand() {

    response = new String();
  }

  private HttpClient configClient() {

    final HttpClient client = getHttpClient();

    client.setStrictMode(true);

    // Se fija el tiempo m´ximo de espera de la respuesta del servidor
    client.setTimeout(60000);

    // Se fija el tiempo m´ximo de espera para conectar con el servidor
    client.setConnectionTimeout(5000);

    return client;
  }

  /**
   * @return
   */
  private PostMethod configPostMethod() {
    // Se fija la URL sobre la que enviar la petici´n POST
    // Como ejemplo la petici´n se env´a a www.altiria.net/sustituirPOSTsms
    // Se debe reemplazar la cadena ’/sustituirPOSTsms’ por la parte
    // correspondiente
    // de la URL suministrada por Altiria al dar de alta el servicio
    final PostMethod post = new PostMethod(URL_SENT_SMS);

    // Se fija la codificaci´n de caracteres en la cabecera de la petici´n
    post.setRequestHeader("Content-type", CONTENT_TYPE);

    return post;
  }

  @Override
  public int execute() {

    final HttpClient httpClient = configClient();

    final PostMethod post = configPostMethod();

    // Se rellena el cuerpo de la petici´n POST con los par´metros
    post.setRequestBody(parametersList);
    int httpStatus = 0;

    httpStatus = executeHttpRequest(httpClient, post, httpStatus);

    if (httpStatus != 200) {
      // error
      return -1;
    }
    else {
      return 1;
    }

  }

  /**
   * @param httpClient
   * @param post
   * @param httpStatus
   * @return
   */
  private int executeHttpRequest(final HttpClient httpClient,
    final PostMethod post, int httpStatus) {

    try {

      // Se env´a la petici´n
      httpStatus = httpClient.executeMethod(post);
      // Se consigue la respuesta
      response = post.getResponseBodyAsString();
    }
    catch (final Exception e) {
      // Habrá que prever la captura de excepciones

    }
    finally {
      // En cualquier caso se cierra la conexi´n
      post.releaseConnection();
    }

    return httpStatus;
  }

}
