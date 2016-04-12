package lala.model.dao;

import java.util.List;

import lala.model.domain.Cliente;

public interface ClienteDao {

	List<Cliente> getClientes();

	Cliente salvar(Cliente cliente);

	void excluir(Cliente cliente);

	void atualizar(Cliente cliente);

}