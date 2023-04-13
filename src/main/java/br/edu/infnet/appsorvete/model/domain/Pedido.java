package br.edu.infnet.appsorvete.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.*;

import br.edu.infnet.appsorvete.model.exceptions.PedidoSemAlimentoException;
import br.edu.infnet.appsorvete.model.exceptions.PedidoSemSolicitanteException;

@Entity
@Table(name = "TPedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String comentario;
	private boolean dinheiro;
	private LocalDateTime data;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private List<Alimento> alimentos;

	public Pedido() {}
	
	public void imprimir() {
		System.out.println("Pedido: " + this);
		System.out.println("Qtde Alimentos: " + alimentos.size());
		System.out.println("Cliente: " + cliente);
		System.out.println("Alimentos: ");
		for(Alimento a : alimentos) {
		System.out.println(" - " + a.getNome());
		}
	}

	public String obterLinha() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");

		return this.getData().format(formato)+";" + this.getComentario() + ";" + this.getCliente() + ";" + this.getAlimentos().size() + "\r\n";
	}

	public Pedido(Cliente cliente, List<Alimento> alimentos) throws PedidoSemSolicitanteException, PedidoSemAlimentoException {
		
		if(cliente == null) {
			throw new PedidoSemSolicitanteException("Não existe nenhum cliente associado ao pedido!");
		}
		
		if(alimentos == null) {
			throw new PedidoSemAlimentoException("Não existe nenhum alimento associado ao pedido!");
		}
		
		this.cliente = cliente;
		this.alimentos = alimentos;

		data = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public boolean isDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(boolean dinheiro) {
		this.dinheiro = dinheiro;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {this.data = data;}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	public List<Alimento> getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	@Override
	public String toString() {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		return String.format("%s;%s;%s", comentario, dinheiro ? "dinheiro" : "cartao", data.format(formato));


	}
}
