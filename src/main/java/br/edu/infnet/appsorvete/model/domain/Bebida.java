package br.edu.infnet.appsorvete.model.domain;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoBebidaInvalidoException;
  
@Entity
@Table(name = "TBebida")
public class Bebida extends Alimento {

	
	private String marca;
	private float tamanho;
	private boolean alcoolico;

	public Bebida() {

	}
	
	public Bebida(float preco, String sabor, int quantidade, String marca) throws PrecoZeradoException {
		super(preco, sabor, quantidade);
		this.marca = marca;
	}
	
	@Override
	public float calcularValorVenda() throws TamanhoBebidaInvalidoException {
		
		if(tamanho < 0.3) {
			throw new TamanhoBebidaInvalidoException ("O tamanho da bebida está inválido!");
		}
		
		float valorAlcoolico = alcoolico ? 3 : 0;
		float valorTamanho = tamanho * 0.05f;
		
		return getPreco() + valorAlcoolico + valorTamanho;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(marca);
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(alcoolico ? "cerveja" : "refri");
		sb.append(";");
		
		return sb.toString();
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isAlcoolico() {
		return alcoolico;
	}
	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}

	
	
	
	
}
