package model.facade.ws;

import java.util.List;


import model.domain.Livro;

public interface LivroFacade {

	List<Livro> getLivros();

	//List<Livro> getLivros(Integer livro);

	Livro salvar(Livro livro);

	void atualizar(Livro livro);

	void deletarLivro(Integer livro);

}