package com.lojaDeComputadorV3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_telefone")
@NamedQueries({ @NamedQuery(name = "Telefone.listar", query = "SELECT telefone FROM Telefone telefone"),
		@NamedQuery(name = "Telefone.buscarPorCodigo", query = "SELECT telefone FROM Telefone telefone WHERE telefone.codigo = :codigo ") })
public class Telefone extends EntidadeDominio {

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo tipo é obrigatório")
	// coluna no banco de dados
	@Column(name = "tel_tipo", length = 15, nullable = false)
	private String tipo;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo ddd é obrigatório")
	// coluna no banco de dados
	@Column(name = "tel_ddd", length = 2, nullable = false)
	private String ddd;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo numero é obrigatório")
	// coluna no banco de dados
	@Column(name = "tel_numero", length = 10, nullable = false)
	private String numero;
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Telefone other = (Telefone) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [tipo=" + tipo + ", ddd=" + ddd + ", numero=" + numero + ", cliente=" + cliente
				+ ", getCodigo()=" + getCodigo() + "]";
	}

	
	
}
