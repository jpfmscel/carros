package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.entidades.Carro;
import br.com.entidades.Pergunta;
import br.com.entidades.Usuario;

public class PerguntaDAO extends BaseDao<Pergunta> {

	@Override
	public Class<Pergunta> getClasse() {
		return Pergunta.class;
	}

	@SuppressWarnings("unchecked")
	public List<Pergunta> getPerguntas(Usuario u) {
		Query q = gerarQueryPerguntas(u);
		if (q == null) {
			return new ArrayList<Pergunta>();
		}
		return ((List<Pergunta>) q.getResultList());
	}

	private Query gerarQueryPerguntas(Usuario u) {
		String nomeClasse = getClasse().getSimpleName();
		StringBuffer sb = new StringBuffer();
		StringBuffer sbMarcas = new StringBuffer();
		int cont = u.getCarros().size();

		for (Carro c : u.getCarros()) {
			if (c.getMarca() != null) {
				sbMarcas.append(c.getMarca().getId() + ",");
				cont++;
			}
		}

		if (sbMarcas.toString().isEmpty()) {
			return null;
		}

		sb.append("Select x from " + nomeClasse + " x where x.marca IN ("
				+ sbMarcas.toString().substring(0, sbMarcas.toString().length() - 1) + ") ");

		return getEntityManager().createQuery(sb.toString());
	}

}
