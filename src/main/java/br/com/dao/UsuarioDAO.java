package br.com.dao;

import java.io.Serializable;
import java.util.List;

import br.com.entidades.Usuario;

public class UsuarioDAO extends BaseDao<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Class<Usuario> getClasse() {
		return Usuario.class;
	}

	public Usuario logarUsuario(String email, String senha) {
		StringBuffer sb = new StringBuffer();
		sb.append("Select x from " + Usuario.class.getSimpleName() + " x where 1=1");
		sb.append(" and senha = '" + senha + "' and email ='" + email + "' and ativo <> 0 ");
		Usuario u = null;
		try {
			u = (Usuario) getEntityManager().createQuery(sb.toString()).getSingleResult();
		} catch (Exception e) {
		}
		return u;
	}

	public Usuario buscarUsuario(String email) {
		StringBuffer sb = new StringBuffer();
		sb.append("Select x from " + Usuario.class.getSimpleName() + " x where 1=1");
		sb.append(" and email = '" + email + "' and ativo <> 0 ");
		Usuario u = null;
		try {
			List resultList = getEntityManager().createQuery(sb.toString()).getResultList();
			if (resultList != null && !resultList.isEmpty()) {
				u = (Usuario) resultList.get(0);
			}
		} catch (Exception e) {
		}
		return u;
	}

}
