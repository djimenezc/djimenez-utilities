package com.djimenez.core.patterns.impl.command;

public interface CommandListener {

  void onAck(String queue, String action, Object to, Object response);

  void onSend(String queue, String action, Object to);
}
