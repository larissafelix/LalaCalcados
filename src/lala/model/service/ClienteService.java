package lala.model.service;

import java.util.List;

import lala.model.domain.Cliente;

public interface ClienteService {

	Cliente salvar(Cliente cliente);

	List<Cliente> getClientes();

	void atualizar(Cliente cliente);

	void excluir(Cliente cliente);

}