package lala.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import lala.model.dao.ProdutoDao;
import lala.model.domain.Produto;

public class ProdutoServiceImpl implements ProdutoService {
	
	@Inject
	private ProdutoDao produtoDao;

	@Override
	public List<Produto> getProdutos() {
		return produtoDao.getProdutos();
	}
	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		return produtoDao.salvar(produto);
	}

	@Override
	@Transactional
	public void excluir(Produto produto){
		produtoDao.excluir(produto);
	}
	
	@Override
	@Transactional
	public void atualizar(Produto produto) {
		produtoDao.atualizar(produto);
	}
}
