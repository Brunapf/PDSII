package domain.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.UsuarioDao;
import model.domain.Usuario;

@WebService(serviceName="ws/usuario")

public class UsuarioFacadeImpl implements UsuarioFacade {

	@Inject
	private UsuarioDao usuarioDao;
	
	
	@Override
	@WebMethod
	public List<Usuario> getUsuarios() {
		return usuarioDao.getusuarios(new Usuario());
	}
	
	@Override
	@WebMethod(operationName="getUsuariosParametro")
	public List<Usuario> getUsuarios(Integer codigo) {
		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		return usuarioDao.getusuarios(usuario);

	}
	
	
	@Override
	@WebMethod
	public Usuario salvar(Usuario usuario) {
		return usuarioDao.salvar(usuario);

	}
	
	
	@Override
	@WebMethod
	public void atualizar(Usuario usuario) {
		usuarioDao.atualizar(usuario);

	}
	
	
	@Override
	@WebMethod
	public void deletarUsuario(Integer codigo) {
		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		usuarioDao.excluir(usuario);
		
	}
	
}