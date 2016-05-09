package br.fa7.spring.loja.services;

import java.util.List;

import br.fa7.spring.loja.entity.Endereco;
import br.fa7.spring.loja.exception.EnderecoNotFoundException;

public interface EnderecoService {

	public List<Endereco> findAll();
	
	public Endereco findById(Long id);
	
	public void insert(Endereco endereco);
	
	public Endereco update(Endereco endereco) throws EnderecoNotFoundException;
	
	public void remove(Long id) throws EnderecoNotFoundException;
	
}
