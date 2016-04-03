package model.dao;

import java.util.List;

import model.domain.Usuario;

public interface UsuarioDao {

	List<Usuario> getusuarios(Usuario usuario);

	public void excluir(Usuario usuario);
	
	public Usuario salvar(Usuario usuario);
	
	public void atualizar(Usuario usuario);
}