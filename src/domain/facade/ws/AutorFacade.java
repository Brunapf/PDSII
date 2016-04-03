package domain.facade.ws;

import java.util.List;



import model.domain.Autor;

public interface AutorFacade {

	List<Autor> getAutores();

	List<Autor> getAutores(Integer autor);

	Autor salvar(Autor autor);

	void atualizar(Autor autor);

	void deletarAutor(Integer autor);

}