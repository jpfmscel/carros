package br.com.dao;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

public abstract class BaseDao<T> {

	@PersistenceContext(unitName = "carros", type = PersistenceContextType.EXTENDED)
	private static EntityManager entityManager;

	public T buscarPorId(int id) {
		return (T) getEntityManager().find(getClasse(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarPorNome(String nome) {
		Query q = gerarQueryNome(nome);
		return ((List<T>) q.getResultList());
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarParteNome(String nome) {
		Query q = gerarQueryParteNome(nome);
		return ((List<T>) q.getResultList());
	}

	private Query gerarQueryParteNome(String nome) {
		String nomeClasse = getClasse().getSimpleName();
		StringBuffer sb = new StringBuffer();

		String titOuNome = "";
		sb.append("Select x from " + nomeClasse + " x where " + titOuNome + " like ('%" + nome + "%')");
		return getEntityManager().createQuery(sb.toString());
	}

	private Query gerarQueryNome(String nome) {
		String nomeClasse = getClasse().getSimpleName();
		StringBuffer sb = new StringBuffer();

		String titOuNome = "";

		sb.append("Select x from " + nomeClasse + " x where " + titOuNome + " = '" + nome + "'");
		return getEntityManager().createQuery(sb.toString());
	}

	public abstract Class<T> getClasse();

	@SuppressWarnings({ "unchecked" })
	public List<T> buscarLista(T o) {
		Query q = gerarQuery(o);
		return (List<T>) q.getResultList();
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> findAll() {
		Query q = gerarQuery(getClasse());
		return (List<T>) q.getResultList();
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> findAllDate(String criterio) {
		Query q = gerarQueryOrderDate(getClasse(), criterio);
		return (List<T>) q.getResultList();
	}

	private Query gerarQuery(Class<T> classe) {
		String nomeClasse = classe.getSimpleName();
		StringBuffer sb = new StringBuffer();
		sb.append("Select x from " + nomeClasse + " x");
		return getEntityManager().createQuery(sb.toString());
	}

	private Query gerarQueryOrderDate(Class<T> classe, String criterio) {
		String nomeClasse = classe.getSimpleName();
		StringBuffer sb = new StringBuffer();
		sb.append("Select x from " + nomeClasse + " x where order by x." + criterio + " desc");
		System.out.println(sb.toString());
		return getEntityManager().createQuery(sb.toString());
	}

	@SuppressWarnings("unchecked")
	public T buscarSingle(T o) {
		Query q = gerarQuery(o);
		return (T) q.getSingleResult();
	}

	public void inserir(T obj) {
		getEntityManager().persist(obj);
	}

	public void update(T obj) {
		getEntityManager().merge(obj);
	}

	private Query gerarQuery(T obj) {

		String nomeClasse = obj.getClass().getSimpleName();
		StringBuffer sb = new StringBuffer();

		sb.append("Select x from " + nomeClasse + " x where 1=1 ");

		try {
			for (Field f : obj.getClass().getDeclaredFields()) {
				f.setAccessible(true);

				if (f.get(obj) != null) {
					if (!f.getName().equalsIgnoreCase("serialVersionUID")) {

						if (f.getName().equalsIgnoreCase("id")) {
							if (((int) f.get(obj)) == 0) {
								sb.append("and " + f.getName() + " > " + f.get(obj));
							} else {
								sb.append("and " + f.getName() + " = " + f.get(obj));
							}
						}
					}
				}
			}
			System.out.println(sb.toString());

		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return getEntityManager().createQuery(sb.toString());
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
