package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name="TB_LIVRO")
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_LIVRO")
	private Integer codigo;
	
	@Column(name="NM_LIVRO")
	private String nome;
	
	@Column(name="DES_PAGINAS")
	private Integer descricao;
	
	@Column(name="QT_PAGINAS")
	private Integer paginas;
	
	@ManyToOne
	@JoinColumn(name="CD_CATEGORIA",referencedColumnName="CD_CATEGORIA")
	private Categoria categorias;
	
	
	@ManyToOne
	@JoinColumn(name="CD_EDITORA",referencedColumnName="CD_EDITORA")
	private Editora editoras;
	
	
	public Livro(){
		
	}

	public Livro(Integer codigo, String nome, Integer descricao, Integer paginas, Categoria categorias,
			Editora editoras) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.paginas = paginas;
		this.categorias = categorias;
		this.editoras = editoras;
		
		
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

	public Integer getDescricao() {
		return descricao;
	}

	public void setDescricao(Integer descricao) {
		this.descricao = descricao;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	

	public Editora getEditoras() {
		return editoras;
	}

	public void setEditoras(Editora editoras) {
		this.editoras = editoras;
	}

	
	
	
		
	@Override
	public String toString() {
		return "Livro [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", paginas=" + paginas + "]";
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
		Livro other = (Livro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
}
