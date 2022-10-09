package br.com.als.antlia.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.als.antlia.api.dto.ProdutoDTO;
import br.com.als.antlia.domain.services.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		var produtos = service.findAll();
		var produtosDTO = produtos.parallelStream().map(ProdutoDTO::new).toList();

		return ResponseEntity.ok(produtosDTO);
	}
}
