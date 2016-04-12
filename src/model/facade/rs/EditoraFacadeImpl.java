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

import model.dao.CategoriaDao;
import model.dao.EditoraDao;
import model.domain.Categoria;
import model.domain.Editora;
import model.facade.ws.EditoraFacade;
import model.service.EditoraService;

@Path("/editora")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class EditoraFacadeImpl implements EditoraFacade {
	
	//@Inject
		//private CategoriaService editoraService;
		
		@Inject
		private EditoraDao editoraDao;

		
		@Override
		@POST
		public Editora salvar(Editora editora) {
		//	return editoraService.salvar(editora);
			return editoraDao.salvar(editora);
		}
		
		
		@Override
		@GET
		public List<Editora> getEditoras() {
			//return editoraService.getCategorias();
			return editoraDao.getEditoras(new Editora());
		}
		
		
		@Override
		@GET
		@Path("/{codigo}")
		public List<Editora> getEditoras(@PathParam("codigo") Integer codigo) {
			Editora editora = new Editora();
			editora.setCodigo(codigo);
			return editoraDao.getEditoras(editora);	
		}
		
		
		
		@Override
		@DELETE
		@Path("/{codigo}")
		public void deletarEditora(@PathParam("codigo") Integer codigo) {
			
				Editora editora = new Editora();
				editora.setCodigo(codigo);
			//	editoraService.excluir(editora);
				editoraDao.excluir(editora);
				
		}


		@Override
		@PUT
		public void atualizar(Editora editora){
			//editoraService.atualizar(editora);
			editoraDao.atualizar(editora);
		}

		
	}