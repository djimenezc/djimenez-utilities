package com.djimenez.pattern.core.worker.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.djimenez.pattern.core.keys.KeyType;
import com.djimenez.pattern.core.view.AbstractWorkerMediator;
import com.djimenez.pattern.impl.command.AbstractCommand;
import com.djimenez.pattern.impl.command.AbstractWorkerCommand;
import com.djimenez.pattern.impl.mediator.AbstractMediator;
import com.djimenez.pattern.interfaces.Command;
import com.djimenez.pattern.interfaces.Facade;
import com.djimenez.pattern.interfaces.mvc.Mediator;
import com.djimenez.pattern.interfaces.worker.WorkerCommand;
import com.djimenez.pattern.interfaces.worker.WorkerMediator;

/**
 * Helper to implements service-to-worker pattern. Create workerCommands and
 * workerMediators in runtime. On the fly, in the heaven, no woman no cry.
 * 
 * @author Ben Jhonson
 */
public class ReflectionWorkerHelper {

  private static final String SUBMIT_METHOD_PREFIX = "submitKey";
  protected static final Logger logger =
    Logger.getLogger(ReflectionWorkerHelper.class);

  /**
   * Create a new instance of NotificationCommand with reflection.
   * 
   * @param reflectionClass
   * @return A interface implementation of reflectionClass parameter
   */
  public static WorkerCommand getWorkerCommandByClassName(
    final String reflectionClass, final Command command) {
    // Class variables
    Class<?> enclosingClass = null, innerClass = null;
    // Object variables
    Object enclosingObject = null, innerObject = null;
    // Constructor
    Constructor<?> constructor;
    // First create the enclosing class for to invoke
    // the constructor of the inner class.
    try {
      enclosingClass = Class.forName(command.getClass().getName());
      // Assign enclosingClass this class
      enclosingObject = command;
      // Find innerClass by reflectionClass name
      for (int i = 0; i < enclosingClass.getDeclaredClasses().length; i++) {
        if (enclosingClass.getDeclaredClasses()[i].getName().equals(
          reflectionClass)) {
          // Get innerClass
          innerClass = enclosingClass.getDeclaredClasses()[i];
          break;
        }
      }
      // Get Constructor
      constructor = innerClass.getDeclaredConstructors()[0];
      // Set accessible to create instancemapClasses
      constructor.setAccessible(true);
      // Get new instance of innerObject
      innerObject = constructor.newInstance(new Object[] { enclosingObject });

    }
    catch (final Exception e) {
      logger.debug("WorkerCommand inner class not found. Reflection failed. ");
    }

    // Return new object
    return (WorkerCommand) innerObject;
  }

  /**
   * @param reflectionClass
   * @param mediator
   * @return WorkerMediator
   */
  public static WorkerMediator getWorkerMediatorByClassName(
    final String reflectionClass, final Mediator mediator) {

    // Class variables
    Class<?> enclosingClass = null, innerClass = null;
    // Object variables
    Object enclosingObject = null, innerObject = null;
    // Constructor
    Constructor<?> constructor;

    try {
      // first create the enclosing class to invoke
      // the constructor of the inner class.
      enclosingClass = Class.forName(mediator.getClass().getName());
      // Assign enclosingClass this class
      enclosingObject = mediator;
      // Find innerClass by reflectionClass name

      for (int i = 0; i < enclosingClass.getDeclaredClasses().length; i++) {
        if (enclosingClass.getDeclaredClasses()[i].getName().equals(
          reflectionClass)) {
          // Get innerClass
          innerClass = enclosingClass.getDeclaredClasses()[i];

          break;
        }
      }
      // Get Constructor
      constructor = innerClass.getDeclaredConstructors()[0];
      // Set accessible to create instancemapClasses
      constructor.setAccessible(true);
      // Get new instance of innerObject
      innerObject = constructor.newInstance(new Object[] { enclosingObject });

    }
    catch (final Exception e) {
      logger.debug("WorkerMediator inner class not found. Reflection failed. ");
    }
    // Return new object
    return (WorkerMediator) innerObject;
  }

  /**
   * Create a new instance of AbstractNotificationCommand with reflection.
   * 
   * @param reflectionClass
   * @return A object implementation of reflectionClass parameter
   */
  public static AbstractWorkerCommand getAbstractWorkerCommandByClassName(
    final String className, final Command command) {
    Class<?> abstractClass;
    AbstractWorkerCommand abstractObject = null;
    // Constructor
    Constructor<?> constructor;

    // Get abstractClass by name
    try {
      abstractClass = Class.forName(className);
      // Get constructor with Facade parameter
      constructor =
        abstractClass.getDeclaredConstructor(new Class[] { Facade.class });
      // Set accesible to create instance
      constructor.setAccessible(true);
      // Create new instance abstractObject
      abstractObject =
        (AbstractWorkerCommand) constructor
          .newInstance(new Object[] { ((AbstractCommand) command).getFacade() });

    }
    catch (final Exception e) {
      logger
        .debug("AbstractWorkerCommand class not found. Reflection failed. ");
    }

    // Return new instance of AbstractWorkerCommand
    return abstractObject;
  }

  /**
   * Create a new instance of AbstractFunctionMediator with reflection.
   * 
   * @param reflectionClass
   * @return A object implementation of reflectionClass parameter
   */
  public static AbstractWorkerMediator getAbstractWorkerMediatorByClassName(
    final String className, final Mediator mediator) {
    Class<?> abstractClass;
    AbstractWorkerMediator abstractObject = null;
    // Constructor
    Constructor<?> constructor;

    // Get abstractClass by name
    try {
      abstractClass = Class.forName(className);
      // Get constructor with Facade parameter
      constructor =
        abstractClass.getDeclaredConstructor(new Class[] { Facade.class });
      // Set accessible to create instance
      constructor.setAccessible(true);
      // Create new instance abstractObject
      abstractObject =
        (AbstractWorkerMediator) constructor
          .newInstance(new Object[] { ((AbstractMediator) mediator).getFacade() });

    }
    catch (final Exception e) {
      logger
        .debug("AbstractWorkerMediator class not found. Reflection failed. ");
    }

    // Return new instance of AbstractWorkerMediator
    return abstractObject;
  }

  /**
   * Get onSubmitKeys methods and set to Mediator the submitKeys type interested
   * 
   * @param workerMediator
   *          Current class or innerClass
   */
  public static void setSubmitKeysInterested(
    final WorkerMediator workerMediator, final Mediator mediator) {
    // Get class of notificationMediator
    final Class<?> workerClass = workerMediator.getClass();
    // Get all methods of workerClass
    final Method[] methods = workerClass.getMethods();
    // Create local variable to keyTypesString interested
    final List<String> keyTypesString = new ArrayList<String>();
    for (final Method method : methods) {
      // If is a submitKey method
      if (method.getName().startsWith(SUBMIT_METHOD_PREFIX)) {
        final String submitKeyMehtod = method.getName();
        // Add keyTypeString to arrayList
        final String keyTypeString =
          submitKeyMehtod.substring(SUBMIT_METHOD_PREFIX.length(),
            submitKeyMehtod.length());
        keyTypesString.add(keyTypeString);
      }
    }
    // Create KeyType[] array with keyTypesString size
    final KeyType[] keyTypes = new KeyType[keyTypesString.size()];
    for (int i = 0; i < keyTypes.length; i++) {
      // Add keyType to KeyType[]
      final KeyType keyType = KeyType.fromString(keyTypesString.get(i));
      keyTypes[i] = keyType;
    }
    // TODO apb002es : Se ha hecho publico porque teniamos una dependencia con
    // mvc-componentes
    // ((AbstractMediator) mediator).setSubmitKeys(keyTypes);
  }

  /**
   * @param workerObject
   * @param submitKey
   * @param operatorLine
   */
  public static void invokeSubmitMethod(final WorkerMediator workerObject,
    final KeyType submitKey, final String operatorLine) {

    // WorkerMediator Class(inner or abstract)
    final Class<?> workerClass = workerObject.getClass();
    Method method;
    try {
      // Get submitKeyXXXX method (XXXX is submitKey pressed)
      method =
        workerClass.getMethod(SUBMIT_METHOD_PREFIX + submitKey.getValue(),
          String.class);
      // Set visibility true
      method.setAccessible(true);
      // Invoke submitKey method of WorkerMediator object
      method.invoke(workerObject, operatorLine);

      // Reflection exceptions
    }
    catch (final Exception e) {
      logger.debug("invoke submit method class not found. Reflection failed. ");
    }
  }
}
