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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name="TB_EDITORA")
public class Editora implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_EDITORA")
	private Integer codigo;
	
	@Size(min=5,message="Nome da Editora precisa ter pelo menos 5 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name="NM_EDITORA")
	private String nome;
	
	@Size(min=10,message="Endereço precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo endereço é obrigatório")
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@NotNull(message="O campo cidade é obrigatório")
	@Column(name="DS_CIDADE")
	private String cidade;
	
	@NotNull(message="O campo cep é obrigatório")
	@Pattern(regexp="\\d{5}-\\d{3}",message="Campo CEP precisa estar no padrão 00000-000")
	@Column(name="DS_CEP")
	private String cep;

	@NotNull(message="O campo país é obrigatório")
	@Column(name="DS_PAIS")
	private String pais;
	
	@NotNull(message="O campo telefone é obrigatório")
	@Size(min=9,message="Descrição precisa ter pelo menos 9 caracteres")
	@Column(name="DS_TELEFONE")
	private String telefone;
	
	@NotNull
	@Size(min=10,message="Descrição precisa ter pelo menos 10 caracteres")
	@Column(name="DS_EDITORA")
	private String descricao;
	
	
	public Editora(){
		
	}

	public Editora(Integer codigo, String nome, String endereco, String cidade, String cep, String pais,
			String telefone, String descricao) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.pais = pais;
		this.telefone = telefone;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	@Override
	public String toString() {
		return "Editora [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade
				+ ", cep=" + cep + ", pais=" + pais + ", telefone=" + telefone + ", descricao=" + descricao + "]";
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
		Editora other = (Editora) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

	
	
	
	
	
}
