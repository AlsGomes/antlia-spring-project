package br.com.als.antlia.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;

import br.com.als.antlia.api.dto.MovimentoManualDTOInput;
import br.com.als.antlia.domain.model.pk.PkMovimentoManual;
import br.com.als.antlia.domain.model.pk.PkProdutoCosif;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "MOVIMENTO_MANUAL")
public class MovimentoManual {

	public MovimentoManual(ProdutoCosif produtoCosif, Integer mes, Integer ano, String descricao, BigDecimal valor) {
		this();
		this.codigo.setProdutoCosif(produtoCosif);
		this.codigo.setMes(mes);
		this.codigo.setAno(ano);
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public MovimentoManual(MovimentoManualDTOInput input) {
		this();
		Produto produto = new Produto();
		produto.setCodigo(input.getCodigoProduto());
		
		PkProdutoCosif pkProdutoCosif = new PkProdutoCosif();
		pkProdutoCosif.setCodigoCosif(input.getCodigoCosif());
		pkProdutoCosif.setProduto(produto);
		
		ProdutoCosif cosif = new ProdutoCosif();
		cosif.setCodigo(pkProdutoCosif);
		
		this.codigo.setProdutoCosif(cosif);
		this.codigo.setMes(input.getMes());
		this.codigo.setAno(input.getAno());
		this.descricao = input.getDescricao();
		this.valor = input.getValor();
	}

	@EqualsAndHashCode.Include
	@EmbeddedId
	private PkMovimentoManual codigo = new PkMovimentoManual();

	@Column(name = "DES_DESCRICAO")
	private String descricao;

	@Column(name = "DAT_MOVIMENTO")
	@CreationTimestamp
	private LocalDateTime dataMovimento;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario = "TESTE";

	@Column(name = "VAL_VALOR")
	private BigDecimal valor;
}
