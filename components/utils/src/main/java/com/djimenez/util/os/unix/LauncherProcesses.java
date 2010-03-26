package com.djimenez.util.os.unix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.log4j.Logger;

/**
 * Launcher processes in unix systems.
 * 
 * @author Rodrigo Villamil Perez
 */
public class LauncherProcesses {

  private static final Logger logger =
    Logger.getLogger(LauncherProcesses.class);

  // Exit process status
  private static final int STATUS_ERR = -1;

  /**
   * Run a process.
   * 
   * @return Exit process status.
   * @param command
   *          System command to execute.
   */
  public static int exec(final String command) throws IOException,
    InterruptedException {

    return exec(command, null, null);
  }

  /**
   * Run a process.
   * 
   * @param command
   *          System command to execute.
   * @param aLogger
   *          Send the information to log.
   */
  public static int exec(final String command, final Logger aLogger)
    throws IOException, InterruptedException {

    int exitStatus = LauncherProcesses.STATUS_ERR;
    String line = null;
    BufferedReader stdInput = null;
    BufferedReader stdError = null;

    // Make a Fork
    final Process processChild = Runtime.getRuntime().exec(command);
    exitStatus = processChild.waitFor();

    stdInput =
      new BufferedReader(new InputStreamReader(processChild.getInputStream()));

    while ((line = stdInput.readLine()) != null) {
      aLogger.info(line);
    }

    try {
      stdInput.close();
    }
    catch (final IOException ex) {
      logger.warn(ex.getMessage());
    }
    finally {
      stdInput = null;
    }

    stdError =
      new BufferedReader(new InputStreamReader(processChild.getErrorStream()));

    while ((line = stdError.readLine()) != null) {
      aLogger.error(line);
    }

    try {
      stdError.close();
    }
    catch (final IOException ex) {
      logger.warn(ex.getMessage());
    }
    finally {
      stdError = null;
    }

    return exitStatus;
  }

  /**
   * Run a process.
   * 
   * @return Exit process status.
   * @param command
   *          System command to execute.
   * @param standarOutPut
   *          If not null, the standard output is redirect to it.
   */
  public static int exec(final String command, final PrintStream standarOutPut)
    throws IOException, InterruptedException {

    return exec(command, standarOutPut, null);
  }

  /**
   * Run a process.
   * 
   * @param command
   *          System command to execute.
   * @param standarOutPut
   *          If not null, the standard output is redirect to it.
   * @param errorOutPut
   *          If not null, the error output is redirect to it.
   */
  public static int exec(final String command, final PrintStream standarOutPut,
    final PrintStream errorOutPut) throws IOException, InterruptedException {

    int exitStatus = LauncherProcesses.STATUS_ERR;
    String line = null;
    BufferedReader stdInput = null;
    BufferedReader stdError = null;

    // Make a Fork
    final Process processChild = Runtime.getRuntime().exec(command);
    exitStatus = processChild.waitFor();

    if (standarOutPut != null) {

      stdInput =
        new BufferedReader(new InputStreamReader(processChild.getInputStream()));

      while ((line = stdInput.readLine()) != null) {
        standarOutPut.println(line);
      }

      try {
        stdInput.close();
      }
      catch (final IOException ex) {
        logger.warn(ex.getMessage());
      }
      finally {
        stdInput = null;
      }
    }

    if (errorOutPut != null) {

      stdError =
        new BufferedReader(new InputStreamReader(processChild.getErrorStream()));

      while ((line = stdError.readLine()) != null) {
        errorOutPut.println(line);
      }

      try {
        stdError.close();
      }
      catch (final IOException ex) {
        logger.warn(ex.getMessage());
      }
      finally {
        stdError = null;
      }
    }

    return exitStatus;
  }
}
