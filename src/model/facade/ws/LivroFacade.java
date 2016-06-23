package model.facade.ws;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Livro;

public interface LivroFacade {

	List<Livro> getLivros();

	List<Livro> getLivros(Integer codigo);
	
	@ValidateOnExecution
	Livro salvar(@Valid Livro livro);

	void atualizar(Livro livro);

	void deletarLivro(Integer livro);

}