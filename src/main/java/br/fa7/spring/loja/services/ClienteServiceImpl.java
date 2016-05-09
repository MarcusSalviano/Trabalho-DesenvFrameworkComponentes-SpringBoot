package br.fa7.spring.loja.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fa7.spring.loja.entity.Cliente;
import br.fa7.spring.loja.exception.ClienteNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Cliente> findAll() {
		return entityManager.createQuery("From Cliente e", Cliente.class).getResultList();
	}

	@Override
	@Transactional
	public void insert(Cliente cliente) {
		entityManager.persist(cliente);
	}

	@Override
	@Transactional (rollbackFor={ClienteNotFoundException.class})
	public Cliente update(Cliente cliente) {
		Cliente ClienteDb = findById(cliente.getId());
		if(ClienteDb!=null){
			ClienteDb.setNome(cliente.getNome());
			ClienteDb.setEmail(cliente.getEmail());
			ClienteDb.setLogin(cliente.getLogin());
			
			return entityManager.merge(ClienteDb);
		}
		throw new ClienteNotFoundException(String.format("Cliente de id '%d' não encontrado", cliente.getId()));
	}

	@Override
	@Transactional
	public void remove(Long id) {
		Cliente Cliente = findById(id);
		if(Cliente!=null){
			entityManager.remove(Cliente);
		}else{
			throw new ClienteNotFoundException(String.format("Cliente de id '%d' não encontrado", id));
		}
	}

	@Override
	public Cliente findById(Long id) {
		return entityManager.find(Cliente.class, id);
	}

}
