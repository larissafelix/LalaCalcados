package lala.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name="TB_CLIENTE")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="CD_CLIENTE")
	private Integer codigo;
	
	@Size(min=3,message="Nome do cliente precisa ter pelo menos 3 caracteres")
	@NotNull(message="O campo nome � obrigat�rio")
	@Column (name="NM_CLIENTE")
	private String nome;
	
	@Pattern(regexp="\\d{4}-\\d{4}",message="Campo Telefone precisa estar no padr�o 0000-0000")
	@NotNull(message="O campo nome � obrigat�rio")
	@Column (name="TL_CLIENTE")
	private Integer telefone;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	public Cliente(){
		
	}

	public Cliente(Integer codigo, String nome, Integer telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
