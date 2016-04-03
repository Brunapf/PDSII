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

import domain.facade.ws.EditoraFacade;
import model.dao.EditoraDao;
import model.domain.Editora;

@Path("/editora")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class EditoraFacadeImpl implements EditoraFacade {
	
	@Inject
	private EditoraDao editoraDao;

	
	@Override
	@POST
	public Editora salvar(Editora editora) {
		editora = editoraDao.salvar(editora);
		return editora;
	}
	
	
	@Override
	@GET
	public List<Editora> getEditoras() {
		return editoraDao.geteditoras(new Editora());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Editora>  getEditoras(@PathParam("codigo") Integer codigo) {
		Editora editora = new Editora();
		editora.setCodigo(codigo);
		return editoraDao.geteditoras(editora);		
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarEditora(@PathParam("codigo") Integer codigo) {
		
			Editora editora = new Editora();
			editora.setCodigo(codigo);
			editoraDao.excluir(editora);
			
	}


	@Override
	@PUT
	public void atualizar(Editora editora){
		editoraDao.atualizar(editora);
	}

	
}
