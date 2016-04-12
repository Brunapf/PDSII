package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.CategoriaDaoImpl;
import model.dao.EditoraDaoImpl;
import model.domain.Categoria;
import model.domain.Editora;

public class EditoraServiceImpl implements EditoraService {

	@Inject
	private EditoraDaoImpl editoraDaoImpl;
	
	
	@Override
	public List<Editora> getEditoras() {
		return editoraDaoImpl.getEditoras(new Editora());
	}
	
	public List<Editora> getEditoras(Integer codigo){
		Editora editora = new Editora();
		editora.setCodigo(codigo);
		return editoraDaoImpl.getEditoras(editora);
	}


	

	
	@Override
	@Transactional
	public Editora salvar(Editora editora) {
		return editoraDaoImpl.salvar(editora);
	}

	
	
	
	@Override
	@Transactional
	public void excluir(Editora editora) {
		editoraDaoImpl.excluir(editora);
		
	}

	

	@Override
	@Transactional
	public void atualizar(Editora editora) {
		editoraDaoImpl.atualizar(editora);
		
	}

}
