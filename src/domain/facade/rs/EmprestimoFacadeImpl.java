package domain.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.facade.ws.EmprestimoFacade;
import model.dao.EmprestimoDao;
import model.domain.Emprestimo;

@Path("/emprestimo")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class EmprestimoFacadeImpl implements EmprestimoFacade {
	
	@Inject
	private EmprestimoDao emprestimoDao;

	
	@Override
	@POST
	public Emprestimo salvar(Emprestimo emprestimo) {
		emprestimo = emprestimoDao.salvar(emprestimo);
		return emprestimo;
	}
	
	
	@Override
	@GET
	public List<Emprestimo> getEmprestimos() {
		return emprestimoDao.getemprestimos(new Emprestimo());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Emprestimo>  getEmprestimos(@PathParam("codigo") Integer codigo) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setCodigo(codigo);
		return emprestimoDao.getemprestimos(emprestimo);		
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarEmprestimo(@PathParam("codigo") Integer codigo) {
		
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setCodigo(codigo);
			emprestimoDao.excluir(emprestimo);
			
	}


	@Override
	@PUT
	public void atualizar(Emprestimo emprestimo){
		emprestimoDao.atualizar(emprestimo);
	}

	
}
