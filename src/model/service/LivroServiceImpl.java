package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.EditoraDaoImpl;
import model.dao.LivroDaoImpl;
import model.domain.Editora;
import model.domain.Livro;

public class LivroServiceImpl implements LivroService {

	@Inject
	private LivroDaoImpl livroDaoImpl;
	
	
	@Override
	public List<Livro> getLivros() {
		return livroDaoImpl.getLivros(new Livro());
	}
	
	public List<Livro> getLivros(Integer codigo){
		Livro livro = new Livro();
		livro.setCodigo(codigo);
		return livroDaoImpl.getLivros(livro);
	}


	

	
	@Override
	@Transactional
	public Livro salvar(Livro livro) {
		return livroDaoImpl.salvar(livro);
	}

	
	
	
	@Override
	@Transactional
	public void excluir(Livro livro) {
		livroDaoImpl.excluir(livro);
		
	}

	

	@Override
	@Transactional
	public void atualizar(Livro livro) {
		livroDaoImpl.atualizar(livro);
		
	}

}