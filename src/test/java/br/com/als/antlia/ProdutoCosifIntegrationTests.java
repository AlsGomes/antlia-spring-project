package br.com.als.antlia;

import static org.assertj.core.api.Assertions.assertThat;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import br.com.als.antlia.domain.model.Produto;
import br.com.als.antlia.domain.model.ProdutoCosif;
import br.com.als.antlia.domain.services.ProdutoCosifService;
import br.com.als.antlia.domain.services.ProdutoService;
import br.com.als.antlia.utils.StringUtils;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class ProdutoCosifIntegrationTests {

	@Autowired
	private Flyway flyway;

	@Autowired
	private ProdutoCosifService cosifService;

	@Autowired
	private ProdutoService produtoService;

	private ProdutoCosif produtoCosifToCreate;

	private Produto produtoToCreate;
	
	@BeforeEach
	private void setup() {
		flyway.migrate();
		prepareData();
	}

	@Test
	public void shouldSuccess_whenCreatingProdutoCosif_withValidData() {
		ProdutoCosif produtoCosif = cosifService.create(produtoCosifToCreate);

		assertThat(produtoCosif).isNotNull();
		assertThat(produtoCosif.getCodigo()).isNotNull();
	}

	private void prepareData() {
		produtoToCreate = Produto.builder()
				.descricao("PRODUTO CRIAÇÃO")
				.status("A")
				.build();
		Produto produto = produtoService.create(produtoToCreate);

		produtoCosifToCreate = new ProdutoCosif(produto, StringUtils.generateCode(6), "A");
	}
}
