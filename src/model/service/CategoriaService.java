package model.service;

import java.util.List;

import javax.transaction.Transactional;

import model.domain.Categoria;

public interface CategoriaService {
	
	List<Categoria> getCategorias(Integer codigo);

	List<Categoria> getCategorias();

	Categoria salvar(Categoria categoria);

	void excluir(Categoria categoria);

	void atualizar(Categoria categoria);

}