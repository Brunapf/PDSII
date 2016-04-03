package domain.facade.ws;

import java.util.List;



import model.domain.Usuario;

public interface UsuarioFacade {

	List<Usuario> getUsuarios();

	List<Usuario> getUsuarios(Integer usuario);

	Usuario salvar(Usuario usuario);

	void atualizar(Usuario usuario);

	void deletarUsuario(Integer usuario);

}