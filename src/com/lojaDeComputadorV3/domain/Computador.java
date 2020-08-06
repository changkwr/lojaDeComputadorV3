package com.lojaDeComputadorV3.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_computador")
@NamedQueries({ @NamedQuery(name = "Computador.listar", query = "SELECT computador FROM Computador computador"),
		@NamedQuery(name = "Computador.buscarPorCodigo", query = "SELECT computador FROM Computador computador WHERE computador.codigo = :codigo ") })
public class Computador extends EntidadeDominio {

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo nome é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_nome", length = 50, nullable = false)
	private String nome;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo gabinete é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_gabinete", length = 50, nullable = false)
	private String gabinete;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo processador é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_processador", length = 50, nullable = false)
	private String processador;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo placadevideo é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_placadevideo", length = 50, nullable = false)
	private String placadevideo;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo placamae é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_placamae", length = 50, nullable = false)
	private String placamae;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo memoria é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_memoria", length = 50, nullable = false)
	private String memoria;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo hdssd é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_hdssd", length = 50, nullable = false)
	private String hdssd;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo fonte é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_fonte", length = 50, nullable = false)
	private String fonte;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo perifericos é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_perifericos", length = 50, nullable = false)
	private String perifericos;
	
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo descricao é obrigatório")
	// coluna no banco de dados
	@Column(name = "comp_descricao", length = 50, nullable = false)
	private String descricao;

	@NotNull(message = "O campo quantidade é obrigatório")
	@Min(value = 0, message = "Informe um valor maior ou igual a zero para o campo quantidade")
	@Max(value = 9999, message = "Informe um valor menor que dez mil para o campo quantidade")
	@Column(name = "comp_quantidade", nullable = false)
	private Integer quantidade;

	// Validação, campo não pode ser um valor nulo
	@NotNull(message = "O campo preço é obrigatório")
	// Validação, valores minimos e maximos para o campo
	@DecimalMin(value = "0.0", message = "Informe um valor maior ou igual a zero para o campo preço")
	@DecimalMax(value = "99999.99", message = "Informe um valor menor que cem mil para o campo preço")
	// Validação, formatação de valor para o campo
	@Digits(integer = 5, fraction = 2, message = "Informe um valor válido para o campo preço")
	@Column(name = "comp_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	@NotNull(message = "O campo produto é obrigatório!")
	// Tipo de relacionamento entre tabelas do banco que contem chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	// juntando as colunas||nome na tabela filha - produto|||nome na tabela pai -
	// produto
	@JoinColumn(name = "tbl_produto_id_codigo", referencedColumnName = "id_codigo")
	private Produto produto;
	
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGabinete() {
		return gabinete;
	}

	public void setGabinete(String gabinete) {
		this.gabinete = gabinete;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getPlacadevideo() {
		return placadevideo;
	}

	public void setPlacadevideo(String placadevideo) {
		this.placadevideo = placadevideo;
	}

	public String getPlacamae() {
		return placamae;
	}

	public void setPlacamae(String placamae) {
		this.placamae = placamae;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getHdssd() {
		return hdssd;
	}

	public void setHdssd(String hdssd) {
		this.hdssd = hdssd;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public String getPerfericos() {
		return perifericos;
	}

	public void setPerfericos(String perfericos) {
		this.perifericos = perfericos;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fonte == null) ? 0 : fonte.hashCode());
		result = prime * result + ((gabinete == null) ? 0 : gabinete.hashCode());
		result = prime * result + ((hdssd == null) ? 0 : hdssd.hashCode());
		result = prime * result + ((memoria == null) ? 0 : memoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perifericos == null) ? 0 : perifericos.hashCode());
		result = prime * result + ((placadevideo == null) ? 0 : placadevideo.hashCode());
		result = prime * result + ((placamae == null) ? 0 : placamae.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((processador == null) ? 0 : processador.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		Computador other = (Computador) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fonte == null) {
			if (other.fonte != null)
				return false;
		} else if (!fonte.equals(other.fonte))
			return false;
		if (gabinete == null) {
			if (other.gabinete != null)
				return false;
		} else if (!gabinete.equals(other.gabinete))
			return false;
		if (hdssd == null) {
			if (other.hdssd != null)
				return false;
		} else if (!hdssd.equals(other.hdssd))
			return false;
		if (memoria == null) {
			if (other.memoria != null)
				return false;
		} else if (!memoria.equals(other.memoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perifericos == null) {
			if (other.perifericos != null)
				return false;
		} else if (!perifericos.equals(other.perifericos))
			return false;
		if (placadevideo == null) {
			if (other.placadevideo != null)
				return false;
		} else if (!placadevideo.equals(other.placadevideo))
			return false;
		if (placamae == null) {
			if (other.placamae != null)
				return false;
		} else if (!placamae.equals(other.placamae))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (processador == null) {
			if (other.processador != null)
				return false;
		} else if (!processador.equals(other.processador))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computador [nome=" + nome + ", gabinete=" + gabinete + ", processador=" + processador
				+ ", placadevideo=" + placadevideo + ", placamae=" + placamae + ", memoria=" + memoria + ", hdssd="
				+ hdssd + ", fonte=" + fonte + ", perfericos=" + perifericos + ", descricao=" + descricao + ", preco="
				+ preco + ", produto=" + produto + ", codigo=" + getCodigo() + "]";
	}

}
