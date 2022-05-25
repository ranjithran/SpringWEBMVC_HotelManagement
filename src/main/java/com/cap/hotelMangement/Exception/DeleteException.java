package com.cap.hotelMangement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Delet bookDetails for this room")  // 404
public class DeleteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}