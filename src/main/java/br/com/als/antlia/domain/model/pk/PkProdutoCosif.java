package br.com.als.antlia.domain.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.als.antlia.domain.model.Produto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class PkProdutoCosif implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "COD_PRODUTO")
	private Produto produto;

	@Column(name = "COD_COSIF")
	private String codigoCosif;
}
