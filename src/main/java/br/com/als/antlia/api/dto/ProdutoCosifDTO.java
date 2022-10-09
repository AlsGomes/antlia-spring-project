package br.com.als.antlia.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.als.antlia.domain.model.ProdutoCosif;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProdutoCosifDTO {
	
	public ProdutoCosifDTO (ProdutoCosif produtoCosif) {
		this.codigoCosif = produtoCosif.getCodigo().getCodigoCosif();
		this.codigoClassificacao = produtoCosif.getCodigoClassificacao();
		this.status = produtoCosif.getStatus();
		this.produto = new ProdutoDTO(produtoCosif.getCodigo().getProduto());
	}
	
	private String codigoCosif;
	private String codigoClassificacao;
	private String status;
	private ProdutoDTO produto;
}
