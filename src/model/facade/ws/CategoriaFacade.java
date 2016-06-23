package model.facade.ws;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Categoria;

public interface CategoriaFacade {

	List<Categoria> getCategorias();

	List<Categoria> getCategorias(Integer codigo);

	@ValidateOnExecution
	Categoria salvar(@Valid Categoria categoria);

	void atualizar(Categoria categoria);

	void deletarCategoria(Integer categoria);

}