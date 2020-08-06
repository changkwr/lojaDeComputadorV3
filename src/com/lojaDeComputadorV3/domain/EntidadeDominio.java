package com.lojaDeComputadorV3.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadeDominio {

	// Chave primaria
	@Id
	// Auto incremento
	@GeneratedValue(strategy = GenerationType.AUTO)
	// Coluna no Banco de Dados e seu nome
	@Column(name = "id_codigo")
	private Long codigo;

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}

		
		
		@Override
		public String toString() {
			return "EntidadeDominio [codigo=" + codigo + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EntidadeDominio other = (EntidadeDominio) obj;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			return true;
		}
		
		
	
}
