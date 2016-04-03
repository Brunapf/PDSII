package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EMPRESTIMO")
public class Emprestimo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_EMPRESTIMO")
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_EMPRESTIMO")
	private Date data_horario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_DEVOLUCAO_EMPRESTIMO")
	private Date data_devolucao;
	
	@ManyToOne
	@JoinColumn(name="CD_USUARIO",referencedColumnName="CD_USUARIO")
	private Usuario usuario;
	
	@ManyToMany
	@JoinTable(name="TB_EMPRESTIMO")
	private List<Livro> livros;
	
	public Emprestimo(){
		
	}

	public Emprestimo(Integer codigo, Date data_horario, Date data_devolucao, Usuario usuario) {
		
		this.codigo = codigo;
		this.data_horario = data_horario;
		this.data_devolucao = data_devolucao;
		this.usuario = usuario;
		this.livros =  new ArrayList<Livro>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData_horario() {
		return data_horario;
	}

	public void setData_horario(Date data_horario) {
		this.data_horario = data_horario;
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public void addlivro(Livro  x){
		this.livros.add(x);
		}

	public void removeAlbum(Livro x){
		this.livros.remove(x);
		}

	@Override
	public String toString() {
		return "Emprestimo [codigo=" + codigo + ", data_horario=" + data_horario + ", data_devolucao=" + data_devolucao
				+ "]";
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
		Emprestimo other = (Emprestimo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
