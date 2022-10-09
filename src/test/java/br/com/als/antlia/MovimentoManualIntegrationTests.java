package br.com.als.antlia;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Calendar;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import br.com.als.antlia.domain.model.MovimentoManual;
import br.com.als.antlia.domain.model.Produto;
import br.com.als.antlia.domain.model.ProdutoCosif;
import br.com.als.antlia.domain.services.MovimentoManualService;
import br.com.als.antlia.domain.services.ProdutoCosifService;
import br.com.als.antlia.domain.services.ProdutoService;
import br.com.als.antlia.utils.StringUtils;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class MovimentoManualIntegrationTests {

	@Autowired
	private Flyway flyway;

	@Autowired
	private MovimentoManualService movService;
	
	@Autowired
	private ProdutoCosifService cosifService;

	@Autowired
	private ProdutoService produtoService;

	private MovimentoManual movToCreate;
	
	private ProdutoCosif produtoCosifToCreate;

	private Produto produtoToCreate;
	
	@BeforeEach
	private void setup() {
		flyway.migrate();
		prepareData();
	}

	@Test
	public void shouldSuccess_whenCreatingMovimentoManual_withValidData() {
		MovimentoManual mov1 = movService.create(movToCreate);

		assertThat(mov1).isNotNull();
		assertThat(mov1.getCodigo()).isNotNull();
	}

	private void prepareData() {
		produtoToCreate = Produto.builder()
				.descricao("PRODUTO CRIAÇÃO")
				.status("A")
				.build();
		Produto produto = produtoService.create(produtoToCreate);

		produtoCosifToCreate = new ProdutoCosif(produto, StringUtils.generateCode(6), "A");
		var cosif = cosifService.create(produtoCosifToCreate);
		
		movToCreate = new MovimentoManual(
				cosif, 
				Calendar.OCTOBER + 1, 
				2022, 
				"Descrição do movimento manual",
				BigDecimal.valueOf(500.00));
	}
}
