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
import model.facade.PedidoFacade;

@Path("/pedido")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoFacadeImpl implements PedidoFacade {

	/* (non-Javadoc)
	 * @see lala.model.facade.rs.PedidoFacade#getPedidos()
	 */
	@Override
	@GET
	public List<Pedido> getPedidos(){
		return getPedidos();
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.PedidoFacade#salvar(lala.model.domain.Pedido)
	 */
	@Override
	@POST
	public Pedido salvar(Pedido pedido){
		pedido.add(pedido);
		pedido.setCodigo(777);
		return pedido;
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.PedidoFacade#atualizar(lala.model.domain.Pedido)
	 */
	@Override
	@PUT
	public void atualizar(Pedido pedido){
		pedido.remove(pedido);
		pedido.add(pedido);
			
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.PedidoFacade#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigoPedido}")
	public void excluir(@PathParam("codigoPedido") Integer codigoPedido){
		Pedido pedido = new Pedido();
		pedido.setCodigo(codigoPedido);
		pedido.remove(pedido);
}
}