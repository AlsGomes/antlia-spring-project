package br.com.als.antlia.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MovimentoManualDTOInput {

	@NotNull
	@Min(value = 1)
	@Max(value = 12)
	private Integer mes;

	@NotNull
	private Integer ano;

	@NotBlank
	private String codigoProduto;

	@NotBlank
	private String codigoCosif;

	@NotNull
	private BigDecimal valor;

	@NotBlank
	@Size(min = 1, max = 50)
	private String descricao;

}
