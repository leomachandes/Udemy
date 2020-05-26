package com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.domain.Cliente;
import com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.gateway.repository.ClienteRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void execute(Cliente cliente) {
		log.info("Gravando cliente.");
		clienteRepository.save(cliente);
		log.info("Cliente gravado com ID = " + cliente.getId());
	}
	
	public Iterable<Cliente> meusClientes() {
		return clienteRepository.findAll();
	}

}
