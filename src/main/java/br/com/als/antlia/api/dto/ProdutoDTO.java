package br.com.als.antlia.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.als.antlia.domain.model.Produto;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProdutoDTO {

	public ProdutoDTO(Produto produto) {
		this.codigo = produto.getCodigo();
		this.descricao = produto.getDescricao();
		this.status = produto.getStatus();
	}

	private String codigo;
	private String descricao;
	private String status;
}
