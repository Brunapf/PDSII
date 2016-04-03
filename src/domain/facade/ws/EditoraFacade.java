package domain.facade.ws;

import java.util.List;



import model.domain.Editora;

public interface EditoraFacade {

	List<Editora> getEditoras();

	List<Editora> getEditoras(Integer editora);

	Editora salvar(Editora editora);

	void atualizar(Editora editora);

	void deletarEditora(Integer editora);

}