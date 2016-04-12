package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.CategoriaDaoImpl;
import model.domain.Categoria;

public class CategoriaServiceImpl implements CategoriaService  {

	@Inject
	private CategoriaDaoImpl categoriaDaoImpl;
	
	/* (non-Javadoc)
	 * @see model.service.CategoriaService#getcategoriaes()
	 */
	
	@Override
	public List<Categoria> getCategorias() {
		return categoriaDaoImpl.getCategorias(new Categoria());
	}
	
	public List<Categoria> getCategorias(Integer codigo){
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		return categoriaDaoImpl.getCategorias(categoria);
	}


	
	/* (non-Javadoc)
	 * @see model.service.CategoriaService#salvar(model.domain.Categoria)
	 */
	
	@Override
	@Transactional
	public Categoria salvar(Categoria categoria) {
		return categoriaDaoImpl.salvar(categoria);
	}

	
	/* (non-Javadoc)
	 * @see model.service.CategoriaService#excluir(model.domain.Categoria)
	 */
	
	@Override
	@Transactional
	public void excluir(Categoria categoria) {
		categoriaDaoImpl.excluir(categoria);
		
	}

	
	/* (non-Javadoc)
	 * @see model.service.CategoriaService#atualizar(model.domain.Categoria)
	 */
	
	@Override
	@Transactional
	public void atualizar(Categoria categoria) {
		categoriaDaoImpl.atualizar(categoria);
		
	}

}
