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

import model.dao.UsuarioDao;
import model.domain.Usuario;
import model.facade.ws.UsuarioFacade;

@Path("/usuario")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class UsuarioFacadeImpl implements UsuarioFacade {
	
	@Inject
	private UsuarioDao usuarioDao;

	
	@Override
	@POST
	public Usuario salvar(Usuario usuario) {
		usuario = usuarioDao.salvar(usuario);
		return usuario;
	}
	
	
	@Override
	@GET
	public List<Usuario> getUsuarios() {
		return usuarioDao.getusuarios(new Usuario());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Usuario>  getUsuarios(@PathParam("codigo") Integer codigo) {
		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		return usuarioDao.getusuarios(usuario);		
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarUsuario(@PathParam("codigo") Integer codigo) {
		
			Usuario usuario = new Usuario();
			usuario.setCodigo(codigo);
			usuarioDao.excluir(usuario);
			
	}


	@Override
	@PUT
	public void atualizar(Usuario usuario){
		usuarioDao.atualizar(usuario);
	}

	
}
