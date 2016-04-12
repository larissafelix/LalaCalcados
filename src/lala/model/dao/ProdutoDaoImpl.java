package lala.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lala.model.domain.Produto;

public class ProdutoDaoImpl implements ProdutoDao {

	@PersistenceContext(unitName="LalaCalcados")
	private EntityManager entityManager;
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> getProdutos() {
		Query query = entityManager.createQuery("from Produto");
		return query.getResultList();
	}

	@Override
	public Produto salvar(Produto produto) {
		entityManager.persist(produto);
		return produto;
	}

	@Override
	public void excluir(Produto produto) {
		Produto produtoMerge = entityManager.merge(produto);
		entityManager.remove(produtoMerge);
	}

	@Override
	public void atualizar(Produto produto) {
		Produto produtoMerge = entityManager.merge(produto);
		entityManager.persist(produtoMerge);
	}

}
