package com.allianzafrica.service;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@RequestMapping("/exception")
	@ExceptionHandler(value = Exception.class)
	public String pageErreur(Model m, Exception e) {
		System.out.println(e.getMessage());
		m.addAttribute("message", e.getMessage());
		return "pagerreur";
	}

}
