package com.lojaDeComputadorV3.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_cliente")
@NamedQueries({ @NamedQuery(name = "Cliente.listar", query = "SELECT cliente FROM Cliente cliente"),
		@NamedQuery(name = "Cliente.buscarPorCodigo", query = "SELECT cliente FROM Cliente cliente WHERE cliente.codigo = :codigo "), 
		@NamedQuery(name = "Cliente.autenticar", query = "SELECT cliente FROM Cliente cliente WHERE cliente.email = :email AND cliente.senha = :senha")
})

public class Cliente extends EntidadeDominio {

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo nome é obrigatório")
	// coluna no banco de dados
	@Column(name = "cli_nome", length = 50, nullable = false)
	private String nome;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo genero é obrigatório")
	// coluna no banco de dados
	@Column(name = "cli_genero", length = 50, nullable = false)
	private String genero;

	// Declara tipo Date
	@Temporal(value = TemporalType.TIMESTAMP)
	@NotNull(message = "O campo data de nascimento é obrigatório")
	@Past(message = "Data deve ser antes do dia corrido")
	@Column(name = "cli_dtnascimento", nullable = false)
	private Date dtNascimento;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo cpf é obrigatório")
	// coluna no banco de dados
	@Column(name = "cli_cpf", length = 50, nullable = false)
	private String cpf;

	@Email
	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo e-mail é obrigatório")
	// coluna no banco de dados
	@Column(name = "cli_email", length = 50, nullable = false)
	private String email;

	// Validação, campo não pode estar vazio
	@NotEmpty(message = "O campo senha é obrigatório")
	// coluna no banco de dados
	@Column(name = "cli_senha", length = 50, nullable = false)
	private String senha;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDtnascimento() {
		return dtNascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtNascimento = dtnascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", genero=" + genero + ", dtnascimento=" + dtNascimento + ", cpf=" + cpf
				+ ", email=" + email + ", senha=" + senha + ", getCodigo()=" + getCodigo() + "]";
	}

}
