package model.facade.ws;

import java.util.List;

import model.domain.Editora;

public interface EditoraFacade {

	List<Editora> getEditoras();

	List<Editora> getEditoras(Integer codigo);

	Editora salvar(Editora editora);

	void atualizar(Editora editora);

	void deletarEditora(Integer editora);

}