package model.facade.ws;

import java.util.List;


import model.domain.Categoria;

public interface CategoriaFacade {

	List<Categoria> getCategorias();

	List<Categoria> getCategorias(Integer codigo);

	Categoria salvar(Categoria categoria);

	void atualizar(Categoria categoria);

	void deletarCategoria(Integer categoria);

}