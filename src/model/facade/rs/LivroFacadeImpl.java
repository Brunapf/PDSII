package model.facade.rs;

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

import model.dao.LivroDao;
import model.domain.Livro;
import model.domain.Livro;
import model.facade.ws.LivroFacade;
import model.service.LivroService;

@Path("/livro")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class LivroFacadeImpl implements LivroFacade {
	
	@Inject
	private LivroService livroService;
	

	
	@Override
	@POST
	public Livro salvar(Livro livro) {
		return livroService.salvar(livro);
	}
	
	
	@Override
	@GET
	public List<Livro> getLivros() {
		return livroService.getLivros();
	}
	
	
	//@Override
	//@GET
	//@Path("/{codigo}")
	//public List<livro>  getlivroes(@PathParam("codigo") Integer codigo) {
	//	livro livro = new livro();
	//	livro.setCodigo(codigo);
	//	return livroDao.getlivroes(livro);		
	//}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarLivro(@PathParam("codigo") Integer codigo) {
		
		Livro livro = new Livro();
			livro.setCodigo(codigo);
			livroService.excluir(livro);
			
	}


	@Override
	@PUT
	public void atualizar(Livro livro){
		livroService.atualizar(livro);
	}
	
}
