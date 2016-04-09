package model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Livro;
public class LivroDaoImpl implements LivroDao{


	@PersistenceContext(unitName="PDSII")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Livro> getLivros() {
	javax.persistence.Query query = entityManager.createQuery("from TB_LIVRO");
		
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
