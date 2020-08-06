package com.lojaDeComputadorV3.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_cartao")
@NamedQueries({ @NamedQuery(name = "Cartao.listar", query = "SELECT cartao FROM Cartao cartao"),
		@NamedQuery(name = "Cartao.buscarPorCodigo", query = "SELECT cartao FROM Cartao cartao WHERE cartao.codigo = :codigo ") })
public class Cartao extends EntidadeDominio {

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo nome é obrigatório")
	// coluna no banco de dados
	@Column(name = "card_nome", length = 50, nullable = false)
	private String nome;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo número do cartão é obrigatório")
	// coluna no banco de dados
	@Column(name = "card_numero", length = 16, nullable = false)
	private String numero;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo bandeira do cartão é obrigatório")
	// coluna no banco de dados
	@Column(name = "card_bandeira", length = 45, nullable = false)
	private String bandeira;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo código de segurança é obrigatório")
	// coluna no banco de dados
	@Column(name = "card_codseguranca", length = 4, nullable = false)
	private String codseguranca;

	// Declara tipo Date
	@Temporal(value = TemporalType.DATE)
	@NotNull(message = "O campo data de vencimento do cartão é obrigatório")
	@Column(name = "card_datavalidade", nullable = false)
	private Date datavalidade;
	
	@NotNull(message = "O campo cliente é obrigatório!")
	// Tipo de relacionamento entre tabelas do banco que contem chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	// juntando as colunas||nome na tabela filha - produto|||nome na tabela pai -
	// produto
	@JoinColumn(name = "tbl_cliente_id_codigo", referencedColumnName = "id_codigo")
	private Cliente cliente;
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDatavalidade() {
		return datavalidade;
	}

	public void setDatavalidade(Date datavalidade) {
		this.datavalidade = datavalidade;
	}

	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getCodseguranca() {
		return codseguranca;
	}

	public void setCodseguranca(String codseguranca) {
		this.codseguranca = codseguranca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bandeira == null) ? 0 : bandeira.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codseguranca == null) ? 0 : codseguranca.hashCode());
		result = prime * result + ((datavalidade == null) ? 0 : datavalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Cartao [nome=" + nome + ", numero=" + numero + ", bandeira=" + bandeira + ", codseguranca="
				+ codseguranca + ", datavalidade=" + datavalidade + ", cliente=" + cliente + ", getCodigo()="
				+ getCodigo() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		if (bandeira == null) {
			if (other.bandeira != null)
				return false;
		} else if (!bandeira.equals(other.bandeira))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codseguranca == null) {
			if (other.codseguranca != null)
				return false;
		} else if (!codseguranca.equals(other.codseguranca))
			return false;
		if (datavalidade == null) {
			if (other.datavalidade != null)
				return false;
		} else if (!datavalidade.equals(other.datavalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
