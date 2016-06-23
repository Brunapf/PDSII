package model.facade.ws;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Editora;

public interface EditoraFacade {

	List<Editora> getEditoras();

	List<Editora> getEditoras(Integer codigo);

	@ValidateOnExecution
	Editora salvar(@Valid Editora editora);

	void atualizar(Editora editora);

	void deletarEditora(Integer editora);

}