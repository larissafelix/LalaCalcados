package lala.model.service;

import java.util.List;

import lala.model.domain.Pedido;

public interface PedidoService {

	Pedido salvar(Pedido pedido);

	List<Pedido> getPedidos();

	void atualizar(Pedido pedido);

	void excluir(Pedido pedido);

}