package br.com.service;

import java.util.List;

import br.com.dao.BaseDao;

public abstract class BaseService<T> {

	public abstract Class<T> getClasse();

	protected abstract BaseDao<T> getDao();

	public void inserir(T obj) {
		getDao().inserir(obj);
	}

	public T buscarPorId(Integer id) {
		return getDao().buscarPorId(id);
	}

	public List<T> buscarParteNome(String nome) {
		return getDao().buscarParteNome(nome);
	}

	public List<T> buscarPorNome(String nome) {
		return getDao().buscarPorNome(nome);
	}

	public void update(T obj) {
		getDao().update(obj);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}

}
