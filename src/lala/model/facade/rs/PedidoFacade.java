package lala.model.facade.rs;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lala.model.domain.Pedido;

@Path("/pedido")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoFacade {

	@GET
	public List<Pedido> getPedidos(){
		return getPedidos();
	}
	@POST
	public Pedido salvar(Pedido pedido){
		pedido.add(pedido);
		pedido.setCodigo(777);
		return pedido;
	}
	@PUT
	public void atualizar(Pedido pedido){
		pedido.remove(pedido);
		pedido.add(pedido);
			
	}
	@DELETE
	@Path("/{codigoPedido}")
	public void excluir(@PathParam("codigoPedido") Integer codigoPedido){
		Pedido pedido = new Pedido();
		pedido.setCodigo(codigoPedido);
		pedido.remove(pedido);
}
}