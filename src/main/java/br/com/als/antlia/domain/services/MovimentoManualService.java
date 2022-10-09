package br.com.als.antlia.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.als.antlia.domain.model.MovimentoManual;
import br.com.als.antlia.domain.repositories.MovimentoManualRepository;

@Service
public class MovimentoManualService {

	@Autowired
	private MovimentoManualRepository repository;

	public List<MovimentoManual> findByMesAndAno(Integer mes, Integer ano){
		return repository.findByMesAndAno(mes, ano);
	}
	
	@Transactional
	public MovimentoManual create(MovimentoManual input) {
		Integer ano = input.getCodigo().getAno();
		Integer mes = input.getCodigo().getMes();

		input.getCodigo().setNrLancamento(getNewNrLancamento(mes, ano));
		return repository.save(input);
	}

	private Long getNewNrLancamento(Integer mes, Integer ano) {
		var movs = repository.findByMesAndAno(mes, ano);
		if (movs.isEmpty())
			return 1L;

		movs.sort(this::compareHandler);
		return movs.get(movs.size() - 1).getCodigo().getNrLancamento() + 1;
	}

	private int compareHandler(MovimentoManual mov1, MovimentoManual mov2) {
		Long nrLancamento1 = mov1.getCodigo().getNrLancamento();
		Long nrLancamento2 = mov2.getCodigo().getNrLancamento();
		return nrLancamento1.compareTo(nrLancamento2);
	}
}
