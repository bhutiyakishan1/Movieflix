package io.egen.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistException(String message) {
		super(message);
	}

}
