package model.dao;

import java.util.List;

import model.domain.Autor;

public interface AutorDao {

	List<Autor> getautores();

	public void excluir(Autor autor);
	
	public Autor salvar(Autor autor);
	
	public void atualizar(Autor autor);
}