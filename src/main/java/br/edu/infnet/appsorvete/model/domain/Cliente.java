package br.edu.infnet.appsorvete.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import br.edu.infnet.appsorvete.model.exceptions.ClienteInvalidoException;
 
@Entity
@Table(name = "TCliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String idade;
	private String email;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@OneToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String idade, String email) throws ClienteInvalidoException {

		this();
		
		if(nome == null) {
			throw new ClienteInvalidoException("O nome do cliente deve ser preenchido");
		}
		if(cpf == null) {
			throw new ClienteInvalidoException("O CPF do cliente deve ser preenchido");
		}
		if(idade == null) {
			throw new ClienteInvalidoException("O idade do cliente deve ser preenchido");
		}
		if(email == null) {
			throw new ClienteInvalidoException("O e-mail do cliente deve ser preenchido");
		}
		
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(cpf);
		sb.append(";");
		sb.append(idade);
		sb.append(";");
		sb.append(email);
		
		return sb.toString();
	}	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
