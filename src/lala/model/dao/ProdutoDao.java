package lala.model.dao;

import java.util.List;

import lala.model.domain.Produto;

public interface ProdutoDao {

	List<Produto> getProdutos();

	Produto salvar(Produto produto);

	void excluir(Produto produto);

	void atualizar(Produto produto);

}