package model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Editora;
import model.domain.Livro;
public class LivroDaoImpl implements LivroDao{


	@PersistenceContext(unitName="PDSII")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Livro> getLivros(Livro livro) {	
		StringBuffer hq1 = new StringBuffer("from Livro c where 1 = 1");
		if (livro.getCodigo() != null) {
			hq1.append(" and c.codigo = :codigo");
		}

		Query query = entityManager.createQuery(hq1.toString());
		if (livro.getCodigo() != null) {
			query.setParameter("codigo", livro.getCodigo());
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