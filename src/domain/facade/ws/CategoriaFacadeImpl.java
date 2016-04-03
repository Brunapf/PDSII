package domain.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.CategoriaDao;
import model.domain.Categoria;
@WebService(serviceName="ws/categoria")
public class CategoriaFacadeImpl implements CategoriaFacade{



	@Inject
	private CategoriaDao categoriaDao;
	
	
	@Override
	@WebMethod
	public List<Categoria> getCategorias() {
		return categoriaDao.getcategorias(new Categoria());
	}
	
	@Override
	@WebMethod(operationName="getcategoriasParametro")
	public List<Categoria> getCategorias(Integer codigo) {
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		return categoriaDao.getcategorias(categoria);

	}
	
	
	@Override
	@WebMethod
	public Categoria salvar(Categoria categoria) {
		return categoriaDao.salvar(categoria);

	}
	
	
	@Override
	@WebMethod
	public void atualizar(Categoria categoria) {
		categoriaDao.atualizar(categoria);

	}
	
	
	@Override
	@WebMethod
	public void deletarCategoria(Integer codigo) {
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		categoriaDao.excluir(categoria);
		
	}
	
}