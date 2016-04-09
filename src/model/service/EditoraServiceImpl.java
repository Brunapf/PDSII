package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.EditoraDaoImpl;
import model.domain.Editora;

public class EditoraServiceImpl implements EditoraService {

	@Inject
	private EditoraDaoImpl editoraDaoImpl;
	
	/* (non-Javadoc)
	 * @see model.service.editoraService#geteditoras()
	 */
	
	/* (non-Javadoc)
	 * @see model.service.EditoraService#getEditoras()
	 */
	
	@Override
	public List<Editora> getEditoras() {
		return editoraDaoImpl.getEditoras();
	}

	
	/* (non-Javadoc)
	 * @see model.service.editoraService#salvar(model.domain.editora)
	 */
	
	/* (non-Javadoc)
	 * @see model.service.EditoraService#salvar(model.domain.Editora)
	 */
	
	@Override
	@Transactional
	public Editora salvar(Editora editora) {
		return editoraDaoImpl.salvar(editora);
	}

	
	/* (non-Javadoc)
	 * @see model.service.editoraService#excluir(model.domain.editora)
	 */
	
	/* (non-Javadoc)
	 * @see model.service.EditoraService#excluir(model.domain.Editora)
	 */
	
	@Override
	@Transactional
	public void excluir(Editora editora) {
		editoraDaoImpl.excluir(editora);
		
	}

	
	/* (non-Javadoc)
	 * @see model.service.editoraService#atualizar(model.domain.editora)
	 */
	
	/* (non-Javadoc)
	 * @see model.service.EditoraService#atualizar(model.domain.Editora)
	 */

	@Override
	@Transactional
	public void atualizar(Editora editora) {
		editoraDaoImpl.atualizar(editora);
		
	}

}
