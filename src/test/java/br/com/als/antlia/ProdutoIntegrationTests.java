package br.com.als.antlia;

import static org.assertj.core.api.Assertions.assertThat;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import br.com.als.antlia.domain.model.Produto;
import br.com.als.antlia.domain.services.ProdutoService;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class ProdutoIntegrationTests {

	@Autowired
	private Flyway flyway;
	
	@Autowired
	private ProdutoService service;
	
	private Produto produtoToCreate;

	@BeforeEach
	private void setup() {
		flyway.migrate();		
		prepareData();
	}
	
	@Test
	public void shouldSuccess_whenCreatingProduto_withValidData() {
		Produto produto = service.create(produtoToCreate);
		
		assertThat(produto).isNotNull();
		assertThat(produto.getCodigo()).isNotNull();
	}

	private void prepareData() {
		produtoToCreate = Produto.builder()
				.descricao("PRODUTO CRIAÇÃO")
				.status("A").build();
	}
}
