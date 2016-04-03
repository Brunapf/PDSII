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

import domain.facade.ws.CategoriaFacade;
import model.dao.CategoriaDao;
import model.domain.Categoria;

@Path("/categoria")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class CategoriaFacadeImpl implements CategoriaFacade {
	
	@Inject
	private CategoriaDao categoriaDao;

	
	@Override
	@POST
	public Categoria salvar(Categoria categoria) {
		categoria = categoriaDao.salvar(categoria);
		return categoria;
	}
	
	
	@Override
	@GET
	public List<Categoria> getCategorias() {
		return categoriaDao.getcategorias(new Categoria());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Categoria>  getCategorias(@PathParam("codigo") Integer codigo) {
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		return categoriaDao.getcategorias(categoria);		
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarCategoria(@PathParam("codigo") Integer codigo) {
		
		Categoria categoria = new Categoria();
			categoria.setCodigo(codigo);
			categoriaDao.excluir(categoria);
			
	}


	@Override
	@PUT
	public void atualizar(Categoria categoria){
		categoriaDao.atualizar(categoria);
	}

	
}
