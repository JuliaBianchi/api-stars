package com.demo;

class NotFoundException extends RuntimeException {

	  NotFoundException(Long id) {
	    super("Could not find star " + id);
	  }
	}