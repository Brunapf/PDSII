package model.dao;

import java.util.List;


import model.domain.Categoria;

public interface CategoriaDao {

		
	public List<Categoria> getCategorias(Categoria categoria);

	public void excluir(Categoria categoria);
	
	public Categoria salvar(Categoria categoria);
	
	public void atualizar(Categoria categoria);
}