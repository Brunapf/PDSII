package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.CategoriaDaoImpl;
import model.domain.Categoria;

public class CategoriaServiceImpl implements CategoriaService  {

	@Inject
	private CategoriaDaoImpl categoriaDaoImpl;
	
	
	@Override
	public List<Categoria> getCategorias() {
		return categoriaDaoImpl.getCategorias(new Categoria());
	}
	
	public List<Categoria> getCategorias(Integer codigo){
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		return categoriaDaoImpl.getCategorias(categoria);
	}


	

	
	@Override
	@Transactional
	public Categoria salvar(Categoria categoria) {
		return categoriaDaoImpl.salvar(categoria);
	}

	
	
	
	@Override
	@Transactional
	public void excluir(Categoria categoria) {
		categoriaDaoImpl.excluir(categoria);
		
	}

	

	@Override
	@Transactional
	public void atualizar(Categoria categoria) {
		categoriaDaoImpl.atualizar(categoria);
		
	}

}
