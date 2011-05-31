package com.sun.samples;

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
 * StockResource.java,v 1.1 2009-11-20 19:43:47 huacui Exp $
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 * 
 * @author mallas
 */

@Path("stock")
public class StockResource {

  @Context
  private UriInfo context;

  private static Map stockData = new HashMap();

  /** Creates a new instance of StockResource */
  public StockResource() {
  }

  private Map getCachedQuote(final String symbol) {
    init();
    Map data = (Map) stockData.get(symbol);
    if (data == null) {
      data = (Map) stockData.get("ORCL");
    }
    data.put("symbol", symbol);
    data.put("company", symbol.toUpperCase());
    return (data);
  }

  /**
   * Retrieves representation of an instance of com.sun.sample.StockResource
   * 
   * @return an instance of java.lang.String
   */
  @GET
  @ProduceMime("application/xml")
  public String getStockResponse(@QueryParam("quote") final String quote) {

    Map map = getYahooQuote(quote);
    if (map == null) {
      map = getCachedQuote(quote);
    }

    final String company = (String) map.get("company");
    final String time = (String) map.get("time");
    final String last = (String) map.get("realValue");
    final String open = (String) map.get("open");
    final String dayHigh = (String) map.get("dayHigh");
    final String dayLow = (String) map.get("dayLow");
    final String yearRange = (String) map.get("yearRange");
    final String marketCap = (String) map.get("marketCap");
    final String symbol = (String) map.get("symbol");
    final String change = (String) map.get("change");
    final StringBuffer sb = new StringBuffer(300);

    sb.append("<QuoteResponse>").append("<Company>").append(company).append(
      "</Company>").append("<Symbol>").append(symbol).append("</Symbol>")
      .append("<Time>").append(time).append("</Time>").append("<Price>")
      .append("<Last>").append(last).append("</Last>").append("<Open>").append(
        open).append("</Open>").append("<DayHigh>").append(dayHigh).append(
        "</DayHigh>").append("<DayLow>").append(dayLow).append("</DayLow>")
      .append("<YearRange>").append(dayLow).append("</YearRange>").append(
        "</Price>").append("<Change>").append(change).append("</Change>")
      .append("<Volume>").append(change).append("</Volume>").append(
        "<MarketCap>").append(change).append("</MarketCap>").append(
        "</QuoteResponse>");

    return sb.toString();
  }

  private String getTime() {
    final GregorianCalendar time = new GregorianCalendar();
    return (time.get(Calendar.MONTH) + "/" + time.get(Calendar.DAY_OF_MONTH)
      + "/" + time.get(Calendar.YEAR) + " " + time.get(Calendar.HOUR) + ":"
      + time.get(Calendar.MINUTE) + time.get(Calendar.AM_PM));
  }

  private Map getYahooQuote(final String ticker) {
    URL url = null;
    try {
      // URL for the stock quote from Yahoo! service
      url =
        new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + ticker
          + "&d=t&f=sl1d1t1c1ohgvj1pp2wern");

      // Set the timeouts for connection and read
      final URLConnection connection = url.openConnection();
      connection.setConnectTimeout(1000);
      connection.setReadTimeout(1000);

      // Request for the stock quote
      final BufferedReader in =
        new BufferedReader(new InputStreamReader(url.openStream()));
      String[] values = null;
      String str;
      if ((str = in.readLine()) != null) {
        values = str.split(",");
      }
      in.close();
      if ((values == null) || (values.length < 16)) {
        return (null);
      }
      // Populate stock values
      final Map map = new HashMap();
      map.put("symbol", removeQuotes(values[0]));
      map.put("company", removeQuotes(values[15]));
      map.put("realValue", values[1]);
      map.put("time", removeQuotes(values[2]) + " " + removeQuotes(values[3]));
      map.put("volume", values[8]);
      map.put("open", values[5]);
      map.put("change", values[4]);
      map.put("dayHigh", values[6]);
      map.put("dayLow", values[7]);
      map.put("yearRange", removeQuotes(values[12]));
      map.put("marketCap", values[9]);
      map.put("message", "");
      return map;
    }
    catch (final MalformedURLException ex) {
      ex.printStackTrace();
    }
    catch (final IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Assign static values for stock quotes. Used as fall-back if quote cannot be
   * obtained from Yahoo!
   */
  private void init() {
    Map stockValues = new HashMap();
    stockValues.put("company", "");
    stockValues.put("realValue", "7.36");
    stockValues.put("volume", "31,793,369");
    stockValues.put("open", "7.37");
    stockValues.put("change", "-0.01");
    stockValues.put("dayHigh", "7.38");
    stockValues.put("dayLow", "7.12");
    stockValues.put("yearRange", "N/A");
    stockValues.put("marketCap", "N/A");
    stockValues.put("message", "User not authenticated."
      + " Quote AUTO Generated");
    stockValues.put("time", getTime());
    stockData.put("JAVA", stockValues);

    stockValues = new HashMap();
    stockValues.put("realValue", "16.35");
    stockValues.put("company", "");
    stockValues.put("volume", "38,544,715");
    stockValues.put("open", "16.35");
    stockValues.put("change", "-0.27");
    stockValues.put("dayHigh", "16.64");
    stockValues.put("dayLow", "16.31");
    stockValues.put("yearRange", "N/A");
    stockValues.put("marketCap", "N/A");
    stockValues.put("message", "User not authenticated."
      + " Quote AUTO Generated");
    stockValues.put("time", getTime());
    stockData.put("ORCL", stockValues);
  }

  /**
   * PUT method for updating or creating an instance of StockResource
   * 
   * @param content
   *          representation for the resource
   * @return an HTTP response with content of the updated or created resource.
   */
  @PUT
  @ConsumeMime("application/xml")
  public void putXml(final String content) {
  }

  private String removeQuotes(final String key) {
    return (key.replaceAll("\"", ""));
  }
}
