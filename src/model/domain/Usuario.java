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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_USUARIO")
	private Integer codigo;
	
	@Column(name="NM_USUARIO")
	private String nome;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@Column(name="DS_CIDADE")
	private String cidade;
	
	@Column(name="DS_CEP")
	private String cep;

	@Column(name="DS_PAIS")
	private String pais;
	
	@Column(name="DS_TELEFONE")
	private String telefone;
	
	@OneToMany(mappedBy="usuario")
	private List<Emprestimo> emprestimos;


	public Usuario() {
		
	}


	public Usuario(Integer codigo, String nome, String endereco, String cidade, String cep, String pais,
			String telefone) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.pais = pais;
		this.telefone = telefone;
		this.emprestimos =  new ArrayList<Emprestimo>();
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


	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}


	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public void addEmprestimo(Emprestimo  x){
		this.emprestimos.add(x);
		}

	public void removeEmprestimo(Emprestimo x){
		this.emprestimos.remove(x);
		}
	
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade
				+ ", cep=" + cep + ", pais=" + pais + ", telefone=" + telefone + "]";
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	

	
	

}
