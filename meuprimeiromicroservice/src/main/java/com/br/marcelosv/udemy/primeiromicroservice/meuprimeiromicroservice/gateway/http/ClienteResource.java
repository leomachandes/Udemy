package com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.gateway.http;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.domain.Cliente;
import com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.gateway.dto.ClienteDTO;
import com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.service.ClienteService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("meu/cliente")
	public void setCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
		log.info("Nome do cliente é " + clienteDTO.getName());
		clienteService.execute(Cliente
				.builder()
				.name(clienteDTO.getName())
				.build());
		
	}
	
	@GetMapping("meu/cliente")
	public ClienteDTO getCliente() {
		return ClienteDTO
				.builder()
				.id(1L)
				.name("Leonardo")
				.build();
	}
	
	@GetMapping("meus/clientes")
	public List<ClienteDTO> meusClientes() {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		
		Iterable<Cliente> all = clienteService.meusClientes();
		all.forEach(cliente -> clientes.add(ClienteDTO
				.builder()
				.id(cliente.getId())
				.name(cliente.getName())
				.build()));
		
		return clientes;
		
	}

}
