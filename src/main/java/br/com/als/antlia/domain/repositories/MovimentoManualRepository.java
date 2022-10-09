package br.com.als.antlia.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.als.antlia.domain.model.MovimentoManual;
import br.com.als.antlia.domain.model.pk.PkMovimentoManual;

public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, PkMovimentoManual> {

	@Query("from MOVIMENTO_MANUAL m where m.codigo.mes = :mes and m.codigo.ano = :ano")
	List<MovimentoManual> findByMesAndAno(Integer mes, Integer ano);
}
