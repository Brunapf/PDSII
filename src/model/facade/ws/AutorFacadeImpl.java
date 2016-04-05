package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.AutorDao;
import model.domain.Autor;

@WebService(serviceName="ws/autor")

public class AutorFacadeImpl implements AutorFacade {

	@Inject
	private AutorDao autorDao;
	
	
	@Override
	@WebMethod
	public List<Autor> getAutores() {
		return autorDao.getautores();
	}
	
	//@Override
	//@WebMethod(operationName="getautorsParametro")
	//public List<Autor> getAutores(Integer codigo) {
	//	Autor autor = new Autor();
	//	autor.setCodigo(codigo);
	//	return autorDao.getautores(autor);

	//}
	
	
	@Override
	@WebMethod
	public Autor salvar(Autor autor) {
		return autorDao.salvar(autor);

	}
	
	
	@Override
	@WebMethod
	public void atualizar(Autor autor) {
		autorDao.atualizar(autor);

	}
	
	
	@Override
	@WebMethod
	public void deletarAutor(Integer codigo) {
		Autor autor = new Autor();
		autor.setCodigo(codigo);
		autorDao.excluir(autor);
		
	}
	
}