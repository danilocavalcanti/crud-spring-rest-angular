package crud.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import crud.rest.model.Cliente;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Cliente> encontrarPorIdENome(Long id, String nome) {
		TypedQuery<Cliente> query = em.createQuery(
				"select c from Cliente c where id = :id and nome = :nome",
				Cliente.class);
		query.setParameter("id", id);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

}
