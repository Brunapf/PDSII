package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Livro;
public class LivroDaoImpl implements LivroDao{

	@PersistenceContext(unitName="SistemaBiblioteca")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Livro> getlivros(Livro livro) {
		StringBuffer hql = new StringBuffer("from livro c"
				+ " where 1 = 1");		
		if (livro.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (livro.getCodigo() != null) {
			query.setParameter("codigo",livro.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Livro livro){
		livro = entityManager.merge(livro);
		entityManager.remove(livro);
	}

	@Override
	@Transactional
	public Livro salvar(Livro livro){
		entityManager.persist(livro);
		return livro;
	}
	
	@Override
	@Transactional
	public void atualizar(Livro livro){
		livro = entityManager.merge(livro);
		entityManager.persist(livro);
		
	}
}
