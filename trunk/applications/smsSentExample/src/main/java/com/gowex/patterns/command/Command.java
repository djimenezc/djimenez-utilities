package com.gowex.patterns.command;

import org.apache.commons.httpclient.NameValuePair;

public interface Command {

  int execute();

  void setParameters(NameValuePair[] parametersList);
}
