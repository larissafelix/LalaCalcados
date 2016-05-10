package lala.model.facade.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lala.model.domain.Cliente;

@Path("/cliente")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteFacade {
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static{
		clientes.add(new Cliente(1,"JOAO",934568794));
	}
	
	@GET
	public List<Cliente> getClientes(){
		return clientes;	
	}
	@POST
	public Cliente salvar(Cliente cliente){
		clientes.add(cliente);
		cliente.setCodigo(777);
		return cliente;
	}
	@PUT
	public void atualizar(Cliente cliente){
		clientes.remove(cliente);
		clientes.add(cliente);
			
	}
	@DELETE
	@Path("/{codigoCliente}")
	public void excluir(@PathParam("codigoCliente") Integer codigoCliente){
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigoCliente);
		clientes.remove(cliente);
}

}

