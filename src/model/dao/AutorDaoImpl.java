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
	public List<Autor> getautores() {
	javax.persistence.Query query = entityManager.createQuery("from Autor");
		
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
