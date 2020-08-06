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
@Table(name = "tbl_log")
@NamedQueries({ @NamedQuery(name = "Log.listar", query = "SELECT log FROM Log log"),
		@NamedQuery(name = "Log.buscarPorCodigo", query = "SELECT log FROM Log log WHERE log.codigo = :codigo ") })
public class Log extends EntidadeDominio {

	// Declara tipo Date
	@Temporal(value = TemporalType.TIMESTAMP)
	@NotEmpty(message = "O campo data de nascimento é obrigatório")
	@Column(name = "log_data", nullable = false)
	private Date data;

	@NotNull(message = "O campo cliente é obrigatório!")
	// Tipo de relacionamento entre tabelas do banco que contem chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	// juntando as colunas||nome na tabela filha - produto|||nome na tabela pai -
	// produto
	@JoinColumn(name = "tbl_cliente_id_codigo", referencedColumnName = "id_codigo")
	private Cliente funcionario;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Cliente funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
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
		Log other = (Log) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Log [data=" + data + ", funcionario=" + funcionario + ", codigo=" + getCodigo() + "]";
	}

}
