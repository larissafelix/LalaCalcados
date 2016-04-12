package lala.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import lala.model.dao.PedidoDao;
import lala.model.domain.Pedido;

public class PedidoServiceImpl implements PedidoService {
	
	@Inject
	private PedidoDao pedidoDao;
	
	/* (non-Javadoc)
	 * @see lala.model.service.PedidoService#getPedidos()
	 */
	@Override
	public List<Pedido> getPedidos() {
		return pedidoDao.getPedidos();
	}
	@Override
	@Transactional
	public Pedido salvar(Pedido pedido) {
		return pedidoDao.salvar(pedido);
	}

	@Override
	@Transactional
	public void excluir(Pedido pedido){
		pedidoDao.excluir(pedido);
	}
	
	@Override
	@Transactional
	public void atualizar(Pedido pedido) {
		pedidoDao.atualizar(pedido);
	}

	/* (non-Javadoc)
	 * @see lala.model.service.PedidoService#excluir(lala.model.domain.Pedido)
	 */

}
