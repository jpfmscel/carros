package br.com.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.BaseDao;
import br.com.dao.UsuarioDAO;
import br.com.entidades.Usuario;

@Stateless
public class UsuarioService extends BaseService<Usuario> {

	@Inject
	private UsuarioDAO dao;

	public Usuario buscarUsuario(String email) {
		return dao.buscarUsuario(email);
	}

	public Usuario logarUsuario(String email, String senha) {
		return dao.logarUsuario(email, senha);
	}

	@Override
	public Class<Usuario> getClasse() {
		return Usuario.class;
	}

	@Override
	protected BaseDao<Usuario> getDao() {
		return dao;
	}

}
