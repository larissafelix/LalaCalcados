package lala.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lala.model.domain.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	@PersistenceContext(unitName="LalaCalcados")
	private EntityManager entityManager;
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		Query query = entityManager.createQuery("from Cliente");
		return query.getResultList();
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}

	@Override
	public void excluir(Cliente cliente) {
		Cliente clienteMerge = entityManager.merge(cliente);
		entityManager.remove(clienteMerge);
	}

	@Override
	public void atualizar(Cliente cliente) {
		Cliente clienteMerge = entityManager.merge(cliente);
		entityManager.persist(clienteMerge);
	}

}
