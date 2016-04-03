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

import model.dao.AutorDao;
import model.domain.Autor;
import model.facade.ws.AutorFacade;

@Path("/autor")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class AutorFacadeImpl implements AutorFacade {
	
	@Inject
	private AutorDao autorDao;

	
	@Override
	@POST
	public Autor salvar(Autor autor) {
		autor = autorDao.salvar(autor);
		return autor;
	}
	
	
	@Override
	@GET
	public List<Autor> getAutores() {
		return autorDao.getautores(new Autor());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Autor>  getAutores(@PathParam("codigo") Integer codigo) {
		Autor autor = new Autor();
		autor.setCodigo(codigo);
		return autorDao.getautores(autor);		
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAutor(@PathParam("codigo") Integer codigo) {
		
			Autor autor = new Autor();
			autor.setCodigo(codigo);
			autorDao.excluir(autor);
			
	}


	@Override
	@PUT
	public void atualizar(Autor autor){
		autorDao.atualizar(autor);
	}

	
}
