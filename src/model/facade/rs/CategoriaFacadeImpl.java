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

import model.domain.Categoria;
import model.facade.ws.CategoriaFacade;
import model.service.CategoriaService;

@Path("/categoria")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class CategoriaFacadeImpl implements CategoriaFacade {
	
	@Inject
	private CategoriaService categoriaService;
	

	
	@Override
	@POST
	public Categoria salvar(Categoria categoria) {
		return categoriaService.salvar(categoria);
	}
	
	
	@Override
	@GET
	public List<Categoria> getCategorias() {
		return categoriaService.getCategorias();
	}
	
	
	//@Override
	//@GET
	//@Path("/{codigo}")
	//public List<categoria>  getcategoriaes(@PathParam("codigo") Integer codigo) {
	//	categoria categoria = new categoria();
	//	categoria.setCodigo(codigo);
	//	return categoriaDao.getcategoriaes(categoria);		
	//}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarCategoria(@PathParam("codigo") Integer codigo) {
		
			Categoria categoria = new Categoria();
			categoria.setCodigo(codigo);
			categoriaService.excluir(categoria);
			
	}


	@Override
	@PUT
	public void atualizar(Categoria categoria){
		categoriaService.atualizar(categoria);
	}

	
}
