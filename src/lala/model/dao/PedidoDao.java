package lala.model.dao;

import java.util.List;

import lala.model.domain.Pedido;

public interface PedidoDao {

	List<Pedido> getPedidos();

	Pedido salvar(Pedido pedido);

	void excluir(Pedido pedido);

	void atualizar(Pedido pedido);

}