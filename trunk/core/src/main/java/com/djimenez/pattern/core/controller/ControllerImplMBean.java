package com.djimenez.pattern.core.controller;

import java.util.Map;

/**
 * JMX Controller Instrumentation
 * 
 * @author djimenez
 * @version 1.0
 */
public interface ControllerImplMBean {

  Map<String, String> getCommandMap();
}
