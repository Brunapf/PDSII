package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.AutorDaoImpl;
import model.domain.Autor;

public class AutorServiceImpl implements AutorService {

	@Inject
	private AutorDaoImpl autorDaoImpl;
	
	@Override
	public List<Autor> getAutores() {
		return autorDaoImpl.getautores();
	}

	
	@Override
	@Transactional
	public Autor salvar(Autor autor) {
		return autorDaoImpl.salvar(autor);
	}

	
	@Override
	@Transactional
	public void excluir(Autor autor) {
		autorDaoImpl.excluir(autor);
		
	}

	
	@Override
	@Transactional
	public void atualizar(Autor autor) {
		autorDaoImpl.atualizar(autor);
		
	}

}
