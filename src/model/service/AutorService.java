package model.service;

import java.util.List;

import model.domain.Autor;

public interface AutorService {

	List<Autor> getAutores();

	Autor salvar(Autor autor);

	void excluir(Autor autor);

	void atualizar(Autor autor);

}