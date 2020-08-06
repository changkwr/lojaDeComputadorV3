package com.lojaDeComputadorV3.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_produto")
@NamedQueries({ @NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto"),
				@NamedQuery(name = "Produto.buscarPorCodigo", query = "SELECT produto FROM Produto produto WHERE produto.codigo = :codigo ") })

public class Produto extends EntidadeDominio {

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo nome é obrigatório")
	// coluna no banco de dados
	@Column(name = "prod_nome", length = 45, nullable = false)
	private String nome;

	@NotEmpty(message = "O campo descrição é obrigatório")
	@Column(name = "prod_descricao", length = 100, nullable = false)
	private String descricao;

	// Validação, campo não pode ser um valor nulo
	@NotNull(message = "O campo preço é obrigatório")
	// Validação, valores minimos e maximos para o campo
	@DecimalMin(value = "0.0", message = "Informe um valor maior ou igual a zero para o campo preço")
	@DecimalMax(value = "99999.99", message = "Informe um valor menor que cem mil para o campo preço")
	// Validação, formatação de valor para o campo
	@Digits(integer = 5, fraction = 2, message = "Informe um valor válido para o campo preço")
	@Column(name = "prod_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	@NotNull(message = "O campo quantidade é obrigatório")
	// Validação, valores minimos e maximos para o campo
	@Min(value = 0, message = "Informe um valor maior ou igual a zero para o campo quantidade")
	@Max(value = 9999, message = "Informe um valor menor que dez mil para o campo quantidade")
	@Column(name = "prod_quantidade", nullable = false)
	private Integer quantidade;

	@NotEmpty(message = "O campo tipo Componente é obrigatório")
	@Column(name = "prod_tipoComponente", length = 100, nullable = false)
	private String tipoComponente;

	public String getTipoComponente() {
		return tipoComponente;
	}

	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

	@Override
	public Long getCodigo() {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	@Override
	public void setCodigo(Long codigo) {
		// TODO Auto-generated method stub
		super.setCodigo(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", quantidade=" + quantidade
				+ ", tipoComponente=" + tipoComponente + ", codigo=" + getCodigo() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((tipoComponente == null) ? 0 : tipoComponente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (tipoComponente == null) {
			if (other.tipoComponente != null)
				return false;
		} else if (!tipoComponente.equals(other.tipoComponente))
			return false;
		return true;
	}

}
