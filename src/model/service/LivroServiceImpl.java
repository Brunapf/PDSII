package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.LivroDaoImpl;
import model.domain.Livro;

public class LivroServiceImpl implements LivroService {

	@Inject
	private LivroDaoImpl livroDaoImpl;
	
	/* (non-Javadoc)
	 * @see model.service.LivroService#getLivros()
	 */
	
	@Override
	public List<Livro> getLivros() {
		return livroDaoImpl.getLivros();
	}

	
	/* (non-Javadoc)
	 * @see model.service.LivroService#salvar(model.domain.Livro)
	 */
	
	@Override
	@Transactional
	public Livro salvar(Livro livro) {
		return livroDaoImpl.salvar(livro);
	}

	
	/* (non-Javadoc)
	 * @see model.service.LivroService#excluir(model.domain.Livro)
	 */
	
	@Override
	@Transactional
	public void excluir(Livro livro) {
		livroDaoImpl.excluir(livro);
		
	}

	
	/* (non-Javadoc)
	 * @see model.service.LivroService#atualizar(model.domain.Livro)
	 */
	
	@Override
	@Transactional
	public void atualizar(Livro livro) {
		livroDaoImpl.atualizar(livro);
		
	}

}
