package model.service;

import java.util.List;

import javax.transaction.Transactional;

import model.domain.Editora;
import model.domain.Livro;

public interface LivroService {

	List<Livro> getLivros(Integer codigo);

	List<Livro> getLivros();

	Livro salvar(Livro livro);

	void excluir(Livro livro);

	void atualizar(Livro livro);

}