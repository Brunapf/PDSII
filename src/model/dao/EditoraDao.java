package model.dao;

import java.util.List;

import model.domain.Editora;

public interface EditoraDao {

	List<Editora> getEditoras();

	public void excluir(Editora categoria);
	
	public Editora salvar(Editora categoria);
	
	public void atualizar(Editora categoria);
}