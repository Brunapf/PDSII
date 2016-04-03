package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(unitName="SistemaBiblioteca")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> getusuarios(Usuario usuario) {
		StringBuffer hql = new StringBuffer("from usuario c"
				+ " where 1 = 1");		
		if (usuario.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (usuario.getCodigo() != null) {
			query.setParameter("codigo",usuario.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Usuario usuario){
		usuario = entityManager.merge(usuario);
		entityManager.remove(usuario);
	}

	@Override
	@Transactional
	public Usuario salvar(Usuario usuario){
		entityManager.persist(usuario);
		return usuario;
	}
	
	@Override
	@Transactional
	public void atualizar(Usuario usuario){
		usuario = entityManager.merge(usuario);
		entityManager.persist(usuario);
		
	}
}
