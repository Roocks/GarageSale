package de.roocks.garagesale.exception;

import javax.ws.rs.WebApplicationException;

public class EntityNotFoundException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
