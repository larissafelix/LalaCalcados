package lala.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import lala.model.dao.ClienteDao;
import lala.model.domain.Cliente;

public class ClienteServiceImpl implements ClienteService {
	
	@Inject
	private ClienteDao clienteDao;
	
	/* (non-Javadoc)
	 * @see lala.model.service.ClienteService#getClientes()
	 */
	@Override
	public List<Cliente> getClientes() {
		return clienteDao.getClientes();
	}
	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteDao.salvar(cliente);
	}

	@Override
	@Transactional
	public void excluir(Cliente cliente){
		clienteDao.excluir(cliente);
	}
	
	@Override
	@Transactional
	public void atualizar(Cliente cliente) {
		clienteDao.atualizar(cliente);
	}

	/* (non-Javadoc)
	 * @see lala.model.service.ClienteService#excluir(lala.model.domain.Cliente)
	 */

}
