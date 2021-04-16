package com.cg.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class PlaycardNotFoundException extends Exception{
		
		private static final Logger logger =  LoggerFactory.getLogger(PlaycardNotFoundException.class);
		private static final long serialVersionUID = 1L;

		public PlaycardNotFoundException(String message){
			
	    	super(message);
	    	logger.info(message);
	    }
}

