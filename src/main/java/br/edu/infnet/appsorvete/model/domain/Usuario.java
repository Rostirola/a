package br.edu.infnet.appsorvete.model.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "TUsuario")
public class Usuario {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private String[] caracteristicas;
	private String tipo;
	private String setor;
	private int idade;
	private float salario;
	private boolean func;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private List<Cliente> clientes;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private List<Alimento> alimentos;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private List<Pedido> pedidos;
	@OneToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Usuario() {
	}
	
	public Usuario(String email, String senha) {
		this();
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public Usuario(String nome, String email, String senha) {
		this(email, senha);
		this.setNome(nome);
	}

	@Override
	public String toString() {

		return String.format(
				"O usuario %s tem as credenciais %s e %s, %d anos e ganha R$%.2f. "
				+ "O um usuario do tipo %s, atua no setor %s e tem %d caracteresticas", 
				nome,
				email,
				senha,
				idade,
				salario,
				tipo,
				setor,
				caracteristicas.length
			);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Alimento> getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isFunc() {
		return func;
	}

	public void setFunc(boolean func) {
		this.func = func;
	}
}