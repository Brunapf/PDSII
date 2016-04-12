package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.LivroDao;

import model.domain.Livro;


@WebService(serviceName="ws/livro")
public class LivroFacadeImpl implements LivroFacade{


	@Inject
	private LivroDao livroDao;
	
	
	@Override
	@WebMethod
	public List<Livro> getLivros() {
		return livroDao.getLivros(new Livro());
	}
	
	@Override
	@WebMethod(operationName="getLivroParametro")
	public List<Livro> getLivros(Integer codigo) {
		Livro livro = new Livro();
		livro.setCodigo(codigo);
		return livroDao.getLivros(livro);

	}
	
	
	@Override
	@WebMethod
	public Livro salvar(Livro livro) {
		return livroDao.salvar(livro);

	}
	
	
	
	@Override
	@WebMethod
	public void atualizar(Livro livro) {
		livroDao.atualizar(livro);

	}
	
	
	@Override
	@WebMethod
	public void deletarLivro(Integer codigo) {
		Livro livro = new Livro();
		livro.setCodigo(codigo);
		livroDao.excluir(livro);
		
	}
	
}