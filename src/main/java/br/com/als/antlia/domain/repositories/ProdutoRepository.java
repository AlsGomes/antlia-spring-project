package br.com.als.antlia.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.als.antlia.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
