package edu.nju.onlinedoc.exceptions;

public class PasswordNotMatchException  extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PasswordNotMatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public PasswordNotMatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public PasswordNotMatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
