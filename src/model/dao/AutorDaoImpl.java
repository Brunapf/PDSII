package model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Autor;
public class AutorDaoImpl implements AutorDao{


	@PersistenceContext(unitName="SistemaBiblioteca")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Autor> getautores(Autor autor) {
		StringBuffer hql = new StringBuffer("from Autor c"
				+ " where 1 = 1");		
		if (autor.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (autor.getCodigo() != null) {
			query.setParameter("codigo",autor.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Autor autor){
		autor = entityManager.merge(autor);
		entityManager.remove(autor);
	}

	@Override
	@Transactional
	public Autor salvar(Autor autor){
		entityManager.persist(autor);
		return autor;
	}
	
	@Override
	@Transactional
	public void atualizar(Autor autor){
		autor = entityManager.merge(autor);
		entityManager.persist(autor);
		
	}
}
