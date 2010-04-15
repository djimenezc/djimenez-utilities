package com.djimenez.webservice.helloworld;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.djimenez.webservice.helloworld.model.Response;

public interface HelloWordService extends Remote {

  Response getResponse(String name, String surname) throws RemoteException;

  String getSaludoLycka(String nombre) throws RemoteException;
}