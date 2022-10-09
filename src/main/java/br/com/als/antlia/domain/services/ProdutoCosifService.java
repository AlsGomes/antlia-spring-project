package br.com.als.antlia.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.als.antlia.domain.model.ProdutoCosif;
import br.com.als.antlia.domain.repositories.ProdutoCosifRepository;

@Service
public class ProdutoCosifService {

	@Autowired
	private ProdutoCosifRepository repository;

	public List<ProdutoCosif> findByCodigoProduto(String codigoProduto) {
		return repository.findByCodigoProduto(codigoProduto);
	}

	public ProdutoCosif create(ProdutoCosif input) {
		return repository.save(input);
	}
}
