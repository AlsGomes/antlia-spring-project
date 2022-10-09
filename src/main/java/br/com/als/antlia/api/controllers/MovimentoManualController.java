package br.com.als.antlia.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.als.antlia.api.dto.MovimentoManualDTO;
import br.com.als.antlia.api.dto.MovimentoManualDTOInput;
import br.com.als.antlia.domain.model.MovimentoManual;
import br.com.als.antlia.domain.services.MovimentoManualService;

@RestController
@RequestMapping("movimentos-manuais")
public class MovimentoManualController {

	@Autowired
	private MovimentoManualService service;

	@GetMapping
	public ResponseEntity<List<MovimentoManualDTO>> findByMesAndAno(@RequestParam Integer mes, @RequestParam Integer ano) {
		var movs = service.findByMesAndAno(mes, ano);
		var movsDTO = movs.stream().map(MovimentoManualDTO::new).toList();
		return ResponseEntity.ok(movsDTO);
	}
	
	@PostMapping
	public ResponseEntity<MovimentoManualDTO> create(@Valid @RequestBody MovimentoManualDTOInput input){
		MovimentoManual mov = new MovimentoManual(input);
		mov = service.create(mov);
		MovimentoManualDTO movDTO = new MovimentoManualDTO(mov);
		return ResponseEntity.status(HttpStatus.CREATED).body(movDTO);
	}
}
