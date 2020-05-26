package com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.gateway.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
public class StatusResource {
	
	@GetMapping("/status")
	@ResponseBody
	public String status() {
		log.info("Método status");
		return "OK";
	}

}
