package br.com.als.antlia.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import br.com.als.antlia.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "PRODUTO")
public class Produto {

	private static final int MAX_CHAR_VALUE = 4;

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "COD_PRODUTO")
	private String codigo;

	@Column(name = "DES_PRODUTO")
	private String descricao;

	@Column(name = "STA_STATUS")
	private String status;

	@PrePersist
	private void setRandomCodigo() {
		this.codigo = StringUtils.generateCode(MAX_CHAR_VALUE);
	}
}
