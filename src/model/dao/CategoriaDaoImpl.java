package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Categoria;

public class CategoriaDaoImpl implements CategoriaDao{


	@PersistenceContext(unitName="SistemaBiblioteca")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> getcategorias(Categoria categoria) {
		StringBuffer hql = new StringBuffer("from categoria c"
				+ " where 1 = 1");		
		if (categoria.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (categoria.getCodigo() != null) {
			query.setParameter("codigo",categoria.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Categoria categoria){
		categoria = entityManager.merge(categoria);
		entityManager.remove(categoria);
	}

	@Override
	@Transactional
	public Categoria salvar(Categoria categoria){
		entityManager.persist(categoria);
		return categoria;
	}
	
	@Override
	@Transactional
	public void atualizar(Categoria categoria){
		categoria = entityManager.merge(categoria);
		entityManager.persist(categoria);
		
	}
}
