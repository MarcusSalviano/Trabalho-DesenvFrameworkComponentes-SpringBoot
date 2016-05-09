package br.fa7.spring.loja.services;

import java.util.List;

import br.fa7.spring.loja.entity.Cliente;
import br.fa7.spring.loja.exception.ClienteNotFoundException;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public void insert(Cliente cliente);
	
	public Cliente update(Cliente cliente) throws ClienteNotFoundException;
	
	public void remove(Long id) throws ClienteNotFoundException;
	
}
