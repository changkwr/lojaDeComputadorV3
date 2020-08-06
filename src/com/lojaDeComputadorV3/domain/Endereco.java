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
@Table(name = "tbl_endereco")
@NamedQueries({ @NamedQuery(name = "Endereco.listar", query = "SELECT endereco FROM Endereco endereco"),
		@NamedQuery(name = "Endereco.buscarPorCodigo", query = "SELECT endereco FROM Endereco endereco WHERE endereco.codigo = :codigo ") })
public class Endereco extends EntidadeDominio {

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo tipo de residencia é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_tiporesidencia", length = 50, nullable = false)
	private String tiporesidencia;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo tipo de logradouro é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_tipologradouro", length = 50, nullable = false)
	private String tipologradouro;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo logradouro é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_logradouro", length = 50, nullable = false)
	private String logradouro;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo numero é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_numero", length = 50, nullable = false)
	private String numero;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo bairro é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_bairro", length = 50, nullable = false)
	private String bairro;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo cep é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_cep", length = 50, nullable = false)
	private String cep;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo cidade é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_cidade", length = 50, nullable = false)
	private String cidade;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo estado é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_estado", length = 50, nullable = false)
	private String estado;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo pais é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_pais", length = 50, nullable = false)
	private String pais;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo complemento é obrigatório")
	// coluna no banco de dados
	@Column(name = "end_complemento", length = 50, nullable = false)
	private String complemento;
	
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

	public String getTiporesidencia() {
		return tiporesidencia;
	}

	public void setTiporesidencia(String tiporesidencia) {
		this.tiporesidencia = tiporesidencia;
	}

	public String getTipologradouro() {
		return tipologradouro;
	}

	public void setTipologradouro(String tipologradouro) {
		this.tipologradouro = tipologradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((tipologradouro == null) ? 0 : tipologradouro.hashCode());
		result = prime * result + ((tiporesidencia == null) ? 0 : tiporesidencia.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (tipologradouro == null) {
			if (other.tipologradouro != null)
				return false;
		} else if (!tipologradouro.equals(other.tipologradouro))
			return false;
		if (tiporesidencia == null) {
			if (other.tiporesidencia != null)
				return false;
		} else if (!tiporesidencia.equals(other.tiporesidencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [tiporesidencia=" + tiporesidencia + ", tipologradouro=" + tipologradouro + ", logradouro="
				+ logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
				+ ", estado=" + estado + ", pais=" + pais + ", complemento=" + complemento + ", cliente=" + cliente
				+ ", getCodigo()=" + getCodigo() + "]";
	}

	
	
}
