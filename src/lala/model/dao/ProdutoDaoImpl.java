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
	public List<Produto> getProdutos(Produto produto) {
		StringBuffer hql = new StringBuffer("from Produto c"+ " where 1 = 1");		
		if (produto.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (produto.getCodigo() != null) {
			query.setParameter("codigo",produto.getCodigo());
		} 
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
		entityManager.remove(produto);
	}

	@Override
	public void atualizar(Produto produto) {
		Produto produtoMerge = entityManager.merge(produto);
		entityManager.persist(produto);
	}

	@Override
	public List<Produto> getProdutos() {
		// TODO Auto-generated method stub
		return null;
	}
}