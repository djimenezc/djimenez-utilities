package com.djimenez.pattern.impl.command;

public interface CommandListener {

  void onSend(String queue, String action, Object to);

  void onAck(String queue, String action, Object to, Object response);
}
