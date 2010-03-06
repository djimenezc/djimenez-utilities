package com.djimenez.pattern.exception;

/**
 *
 * @author djimenez
 * @version 1.0
 */
public class ObserverEntryException extends RuntimeException{
	public static final long serialVersionUID = 1L;

	public ObserverEntryException(String message) {
		super(message);
	}

	public ObserverEntryException(String message, Throwable cause) {
		super(message, cause);
	}
}
