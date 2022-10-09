package br.com.als.antlia.api.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.als.antlia.domain.model.MovimentoManual;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class MovimentoManualDTO {

	public MovimentoManualDTO(MovimentoManual movimentoManual) {
		this.mes = movimentoManual.getCodigo().getMes();
		this.ano = movimentoManual.getCodigo().getAno();
		this.valor = movimentoManual.getValor();
		this.descricao = movimentoManual.getDescricao();
		this.nrLancamento = movimentoManual.getCodigo().getNrLancamento();
		this.produtoCosif = new ProdutoCosifDTO(movimentoManual.getCodigo().getProdutoCosif());
	}

	private Integer mes;
	private Integer ano;
	private ProdutoCosifDTO produtoCosif;
	private BigDecimal valor;
	private String descricao;
	private Long nrLancamento;
}
