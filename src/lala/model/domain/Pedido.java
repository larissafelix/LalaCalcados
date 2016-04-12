package lala.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_PEDIDO")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="CD_PEDIDO")
	private Integer codigo;
	@ManyToMany
	@JoinColumn(name="CD_PRODUTO",referencedColumnName="CD_PRODUTO")
	private List<Produto> produtos;
	
	@ManyToMany
	@JoinColumn(name="CD_PRODUTO",referencedColumnName="CD_PRODUTO")
	private List<Cliente> cliente;
	private Produto produto;
	
	
	public Pedido(){
		
	}
	public Pedido(Integer codigo, Produto produto, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.produto = produto;
		this.cliente = (List<Cliente>) cliente;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return (Cliente) cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = (List<Cliente>) cliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	public void add(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}
	public void remove(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}
	
	
}
