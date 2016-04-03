package model.dao;

import java.util.List;

import model.domain.Livro;

public interface LivroDao {

	List<Livro> getlivros(Livro livro);

	public void excluir(Livro livro);
	
	public Livro salvar(Livro livro);
	
	public void atualizar(Livro livro);
}