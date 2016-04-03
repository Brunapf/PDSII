package domain.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.EditoraDao;
import model.domain.Editora;
@WebService(serviceName="ws/editora")
public class EditoraFacadeImpl implements EditoraFacade{

	@Inject
	private EditoraDao editoraDao;
	
	
	@Override
	@WebMethod
	public List<Editora> getEditoras() {
		return editoraDao.geteditoras(new Editora());
	}
	
	@Override
	@WebMethod(operationName="geteditorasParametro")
	public List<Editora> getEditoras(Integer codigo) {
		Editora editora = new Editora();
		editora.setCodigo(codigo);
		return editoraDao.geteditoras(editora);

	}
	
	
	@Override
	@WebMethod
	public Editora salvar(Editora editora) {
		return editoraDao.salvar(editora);

	}
	
	
	@Override
	@WebMethod
	public void atualizar(Editora editora) {
		editoraDao.atualizar(editora);

	}
	
	
	@Override
	@WebMethod
	public void deletarEditora(Integer codigo) {
		Editora editora = new Editora();
		editora.setCodigo(codigo);
		editoraDao.excluir(editora);
		
	}
	
}