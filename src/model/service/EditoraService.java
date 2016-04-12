package model.service;

import java.util.List;

import javax.transaction.Transactional;

import model.domain.Categoria;
import model.domain.Editora;

public interface EditoraService {

	List<Editora> getEditoras(Integer codigo);

	List<Editora> getEditoras();

	Editora salvar(Editora editora);

	void excluir(Editora editora);

	void atualizar(Editora editora);

}