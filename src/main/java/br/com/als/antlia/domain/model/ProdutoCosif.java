package br.com.als.antlia.domain.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

import br.com.als.antlia.domain.model.pk.PkProdutoCosif;
import br.com.als.antlia.utils.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "PRODUTO_COSIF")
public class ProdutoCosif {

	private static final int MAX_CHAR_VALUE = 11;

	public ProdutoCosif(Produto produto, String codigoClassificacao, String status) {
		this.codigo.setProduto(produto);
		this.codigoClassificacao = codigoClassificacao;
		this.status = status;
	}

	@EqualsAndHashCode.Include
	@EmbeddedId
	private PkProdutoCosif codigo = new PkProdutoCosif();

	@Column(name = "COD_CLASSIFICACAO")
	private String codigoClassificacao;

	@Column(name = "STA_STATUS")
	private String status;

	@PrePersist
	private void setRandomCodigo() {
		this.codigo.setCodigoCosif(StringUtils.generateCode(MAX_CHAR_VALUE));
	}
}
