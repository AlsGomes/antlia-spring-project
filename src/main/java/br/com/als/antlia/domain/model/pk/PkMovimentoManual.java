package br.com.als.antlia.domain.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import br.com.als.antlia.domain.model.ProdutoCosif;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class PkMovimentoManual implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumns({ 
		@JoinColumn(name = "COD_COSIF"),
		@JoinColumn(name = "COD_PRODUTO")
	})
	private ProdutoCosif produtoCosif;

	@Column(name = "DAT_MES")
	private Integer mes;

	@Column(name = "DAT_ANO")
	private Integer ano;

	@Column(name = "NUM_LANCAMENTO")
	private Long nrLancamento;

}
