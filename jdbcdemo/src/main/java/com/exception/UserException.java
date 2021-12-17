/**
 * 
 */
package com.exception;

/**
 * @author nithish.kumarb
 *
 */
public class UserException extends Exception {
	private String errorMessage;

	public UserException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
