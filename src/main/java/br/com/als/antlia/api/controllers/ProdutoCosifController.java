package br.com.als.antlia.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.als.antlia.api.dto.ProdutoCosifDTO;
import br.com.als.antlia.domain.services.ProdutoCosifService;

@RestController
@RequestMapping("produtos-cosif")
public class ProdutoCosifController {

	@Autowired
	private ProdutoCosifService service;

	@GetMapping
	public ResponseEntity<List<ProdutoCosifDTO>> findAll(@RequestParam(defaultValue = "") String codProd) {
		var produtosCosif = service.findByCodigoProduto(codProd);
		var produtosCosifDTO = produtosCosif.stream().map(ProdutoCosifDTO::new).toList();

		return ResponseEntity.ok(produtosCosifDTO);
	}
}
