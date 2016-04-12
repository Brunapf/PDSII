package model.dao;

import java.util.List;


import model.domain.Editora;

public interface EditoraDao {

	public List<Editora> getEditoras(Editora editoras);

	public void excluir(Editora editoras);
	
	public Editora salvar(Editora editoras);
	
	public void atualizar(Editora editoras);
}