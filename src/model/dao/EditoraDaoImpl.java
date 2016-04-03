package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Editora;
public class EditoraDaoImpl implements EditoraDao{


	@PersistenceContext(unitName="SistemaBiblioteca")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Editora> geteditoras(Editora editora) {
		StringBuffer hql = new StringBuffer("from editora c"
				+ " where 1 = 1");		
		if (editora.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (editora.getCodigo() != null) {
			query.setParameter("codigo",editora.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Editora editora){
		editora = entityManager.merge(editora);
		entityManager.remove(editora);
	}

	@Override
	@Transactional
	public Editora salvar(Editora editora){
		entityManager.persist(editora);
		return editora;
	}
	
	@Override
	@Transactional
	public void atualizar(Editora editora){
		editora = entityManager.merge(editora);
		entityManager.persist(editora);
		
	}
}
