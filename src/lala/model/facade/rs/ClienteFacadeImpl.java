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
import model.facade.ClienteFacade;

@Path("/cliente")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteFacadeImpl implements ClienteFacade {
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static{
		clientes.add(new Cliente(1,"JOAO",934568794));
	}
	
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ClienteFacade#getClientes()
	 */
	@Override
	@GET
	public List<Cliente> getClientes(){
		return clientes;	
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ClienteFacade#salvar(lala.model.domain.Cliente)
	 */
	@Override
	@POST
	public Cliente salvar(Cliente cliente){
		clientes.add(cliente);
		cliente.setCodigo(777);
		return cliente;
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ClienteFacade#atualizar(lala.model.domain.Cliente)
	 */
	@Override
	@PUT
	public void atualizar(Cliente cliente){
		clientes.remove(cliente);
		clientes.add(cliente);
			
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ClienteFacade#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigoCliente}")
	public void excluir(@PathParam("codigoCliente") Integer codigoCliente){
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigoCliente);
		clientes.remove(cliente);
}
}