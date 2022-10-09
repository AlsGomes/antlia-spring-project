package br.com.als.antlia.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.als.antlia.domain.model.ProdutoCosif;
import br.com.als.antlia.domain.model.pk.PkProdutoCosif;

public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, PkProdutoCosif> {

	@Query("from PRODUTO_COSIF p where p.codigo.produto.codigo = :codigo")
	List<ProdutoCosif> findByCodigoProduto(String codigo);
}
