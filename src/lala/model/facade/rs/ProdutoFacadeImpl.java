package lala.model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lala.model.domain.Produto;
import lala.model.service.ProdutoService;
import model.facade.ProdutoFacade;

@Path("/produto")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoFacadeImpl implements ProdutoFacade {
	@Inject
	private ProdutoService produtoService;
	
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ProdutoFacade#getProdutos()
	 */
	@Override
	@GET
	public List<Produto> getProdutos(){
		return produtoService.getProdutos();	
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ProdutoFacade#salvar(lala.model.domain.Produto)
	 */
	@Override
	@POST
	public Produto salvar(Produto produto){
		return produtoService.salvar(produto);
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ProdutoFacade#atualizar(lala.model.domain.Produto)
	 */
	@Override
	@PUT
	public void atualizar(Produto produto){
		produtoService.atualizar(produto);	
	}
	/* (non-Javadoc)
	 * @see lala.model.facade.rs.ProdutoFacade#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigoProduto}")
	public void excluir(@PathParam("codigoProduto") Integer codigoProduto){
		Produto produto = new Produto();
		produto.setCodigo(codigoProduto);
		produtoService.excluir(produto);	
}
}