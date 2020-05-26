package com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.gateway.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.marcelosv.udemy.primeiromicroservice.meuprimeiromicroservice.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
