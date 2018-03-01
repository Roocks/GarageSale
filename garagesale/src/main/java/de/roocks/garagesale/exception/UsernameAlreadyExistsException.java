package de.roocks.garagesale.exception;

import javax.ws.rs.WebApplicationException;

public class UsernameAlreadyExistsException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}
}
