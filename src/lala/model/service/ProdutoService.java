package lala.model.service;

import java.util.List;

import lala.model.domain.Produto;

public interface ProdutoService {

	Produto salvar(Produto produto);

	List<Produto> getProdutos();

	void atualizar(Produto produto);

	void excluir(Produto produto);

}