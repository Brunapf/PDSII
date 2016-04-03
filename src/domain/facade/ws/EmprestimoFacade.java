package domain.facade.ws;

import java.util.List;



import model.domain.Emprestimo;

public interface EmprestimoFacade {

	List<Emprestimo> getEmprestimos();

	List<Emprestimo> getEmprestimos(Integer emprestimo);

	Emprestimo salvar(Emprestimo emprestimo);

	void atualizar(Emprestimo emprestimo);

	void deletarEmprestimo(Integer emprestimo);

}