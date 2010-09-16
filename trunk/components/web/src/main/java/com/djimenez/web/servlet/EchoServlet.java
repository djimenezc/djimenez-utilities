package com.djimenez.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.StringUtils;

public class EchoServlet extends GenericServlet {

  private static final long serialVersionUID = 9175426162144165731L;

  @SuppressWarnings("unchecked")
  @Override
  public void service(final ServletRequest request,
    final ServletResponse response) throws ServletException, IOException {

    final PrintWriter out = response.getWriter();

    final Map<String, String[]> params =
      new TreeMap<String, String[]>(request.getParameterMap());

    out.println("SIZE=" + params.size());
    for (final Entry<String, String[]> entry : params.entrySet()) {
      out.println(entry.getKey() + ":::"
        + StringUtils.join(entry.getValue(), ","));
    }
  }
}