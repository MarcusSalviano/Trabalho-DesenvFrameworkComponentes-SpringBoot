package br.fa7.spring.loja.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fa7.spring.loja.entity.Endereco;
import br.fa7.spring.loja.exception.EnderecoNotFoundException;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Endereco> findAll() {
		return entityManager.createQuery("From Endereco e", Endereco.class).getResultList();
	}

	@Override
	@Transactional
	public void insert(Endereco endereco) {
		entityManager.persist(endereco);
	}

	@Override
	@Transactional(rollbackFor = { EnderecoNotFoundException.class })
	public Endereco update(Endereco endereco) {
		Endereco EnderecoDb = findById(endereco.getId());
		if (EnderecoDb != null) {
			EnderecoDb.setLogradouro(endereco.getLogradouro());
			EnderecoDb.setComplemento(endereco.getComplemento());
			EnderecoDb.setCep(endereco.getCep());

			return entityManager.merge(EnderecoDb);
		}
		throw new EnderecoNotFoundException(String.format("Endereco de id '%d' não encontrado", endereco.getId()));
	}

	@Override
	@Transactional
	public void remove(Long id) {
		Endereco Endereco = findById(id);
		if (Endereco != null) {
			entityManager.remove(Endereco);
		} else {
			throw new EnderecoNotFoundException(String.format("Endereco de id '%d' não encontrado", id));
		}
	}

	@Override
	public Endereco findById(Long id) {
		return entityManager.find(Endereco.class, id);
	}

}
