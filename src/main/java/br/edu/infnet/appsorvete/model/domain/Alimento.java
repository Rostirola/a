package br.edu.infnet.appsorvete.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoMilkshakeInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoSorveteInvalidoException;
 
@Entity
@Table(name = "TAlimento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Alimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private float preco;
	private String sabor;
	private int quantidade;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "alimentos")
	private List<Pedido> pedidos;

	public Alimento() {

	}
	
	public Alimento(float preco, String sabor, int quantidade) throws PrecoZeradoException {
		
		if(preco == 0) {
			 throw new PrecoZeradoException("O preco esta zerado!");
		}
		
		if(preco < 0) {
			 throw new PrecoZeradoException("O preco esta negativo!");
		}
		
		this.preco = preco;
		this.sabor = sabor;
		this.quantidade = quantidade;
	}
	
	public abstract float calcularValorVenda() throws TamanhoBebidaInvalidoException, TamanhoMilkshakeInvalidoException,TamanhoSorveteInvalidoException;
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(preco);
		sb.append(";");
		sb.append(sabor);
		sb.append(";");
		sb.append(quantidade);
		sb.append(";");
		
		return sb.toString();
	}

	public float getPreco() {
		return preco;
	}

	public String getSabor() {
		return sabor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	} 
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
