package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name="TB_CATEGORIA")
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_CATEGORIA")
	private Integer codigo;
	
	@Size(min=4,message="Nome da categoria precisa ter pelo menos 4 caracteres")
	@NotNull(message="O campo nome da categoria é obrigatório")
	@Column(name="NM_CATEGORIA")
	private String nome;
	
	@NotNull
	@Size(min=10,message="A descrição precisa ter pelo menos 10 caracteres")
	@Column(name="DS_CATEGORIA")
	private String descricao;
	



	public Categoria(){
		
	}


	public Categoria(Integer codigo, String nome, String descricao) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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



	
	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + "]";
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
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

	
	

	
	
	
	
}
