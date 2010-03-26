package com.djimenez.webservice.helloworld;

import java.rmi.RemoteException;

import com.djimenez.webservice.helloworld.model.Response;

public class HelloWordServiceImpl implements HelloWordService {

  @Override
  public Response getResponse(final String name, final String surname)
    throws RemoteException {

    final Response response = new Response(name, surname);

    return response;
  }

  @Override
  public String getSaludoLycka(final String nombre) throws RemoteException {
    return "Lycka te saluda, " + nombre + ".";
  }
}