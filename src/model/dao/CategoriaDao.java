package model.dao;

import java.util.List;

import model.domain.Categoria;

public interface CategoriaDao {

	List<Categoria> getcategorias(Categoria categoria);

	public void excluir(Categoria categoria);
	
	public Categoria salvar(Categoria categoria);
	
	public void atualizar(Categoria categoria);
}