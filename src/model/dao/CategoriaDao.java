package model.dao;

import java.util.List;

import model.domain.Categoria;

public interface CategoriaDao {

	List<Categoria> getCategorias();

	public void excluir(Categoria categoria);
	
	public Categoria salvar(Categoria categoria);
	
	public void atualizar(Categoria categoria);
}