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
@Table(name = "tbl_compras")
@NamedQueries({ @NamedQuery(name = "Compras.listar", query = "SELECT compras FROM Compras compras"),
		@NamedQuery(name = "Compras.buscarPorCodigo", query = "SELECT compras FROM Compras compras WHERE compras.codigo = :codigo ") })
public class Compras extends EntidadeDominio {

	// Declara tipo Date
	@Temporal(value = TemporalType.TIMESTAMP)
	@NotEmpty(message = "O campo data é obrigatório")
	@Column(name = "com_data", nullable = false)
	private Date data;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo status é obrigatório")
	// coluna no banco de dados
	@Column(name = "com_status", length = 50, nullable = false)
	private String status;

	// Tipo de relacionamento entre tabelas do banco que contem chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	// juntando as colunas||nome na tabela filha|||nome na tabela pai
	@JoinColumn(name = "tbl_computador_id_codigo", referencedColumnName = "id_codigo", nullable = false)
	private Computador computador;
	
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Computador getComputador() {
		return computador;
	}

	public void setComputador(Computador computador) {
		this.computador = computador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((computador == null) ? 0 : computador.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Compras other = (Compras) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (computador == null) {
			if (other.computador != null)
				return false;
		} else if (!computador.equals(other.computador))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compras [data=" + data + ", status=" + status + ", computador=" + computador + ", cliente=" + cliente
				+ ", getCodigo()=" + getCodigo() + "]";
	}



	
	
}
