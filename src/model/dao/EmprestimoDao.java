package model.dao;

import java.util.List;

import model.domain.Emprestimo;

public interface EmprestimoDao {

	List<Emprestimo> getemprestimos(Emprestimo emprestimo);

	public void excluir(Emprestimo emprestimo);
	
	public Emprestimo salvar(Emprestimo emprestimo);
	
	public void atualizar(Emprestimo emprestimo);
}