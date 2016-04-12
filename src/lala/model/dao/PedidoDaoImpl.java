package lala.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lala.model.domain.Pedido;

public class PedidoDaoImpl implements PedidoDao {

	@PersistenceContext(unitName="LalaCalcados")
	private EntityManager entityManager;
	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos() {
		Query query = entityManager.createQuery("from Pedido");
		return query.getResultList();
	}

	@Override
	public Pedido salvar(Pedido pedido) {
		entityManager.persist(pedido);
		return pedido;
	}

	@Override
	public void excluir(Pedido pedido) {
		Pedido pedidoMerge = entityManager.merge(pedido);
		entityManager.remove(pedidoMerge);
	}

	@Override
	public void atualizar(Pedido pedido) {
		Pedido pedidoMerge = entityManager.merge(pedido);
		entityManager.persist(pedidoMerge);
	}

}
