package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.EmprestimoDao;
import model.domain.Emprestimo;
@WebService(serviceName="ws/emprestimo")
public class EmprestimoFacadeImpl implements EmprestimoFacade{


	@Inject
	private EmprestimoDao emprestimoDao;
	
	
	@Override
	@WebMethod
	public List<Emprestimo> getEmprestimos() {
		return emprestimoDao.getemprestimos(new Emprestimo());
	}
	
	@Override
	@WebMethod(operationName="getemprestimosParametro")
	public List<Emprestimo> getEmprestimos(Integer codigo) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setCodigo(codigo);
		return emprestimoDao.getemprestimos(emprestimo);

	}
	
	
	@Override
	@WebMethod
	public Emprestimo salvar(Emprestimo emprestimo) {
		return emprestimoDao.salvar(emprestimo);

	}
	
	
	@Override
	@WebMethod
	public void atualizar(Emprestimo emprestimo) {
		emprestimoDao.atualizar(emprestimo);

	}
	
	
	@Override
	@WebMethod
	public void deletarEmprestimo(Integer codigo) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setCodigo(codigo);
		emprestimoDao.excluir(emprestimo);
		
	}
	
}