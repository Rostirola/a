package br.edu.infnet.appsorvete.model.domain;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
 
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoMilkshakeInvalidoException;
 
@Entity
@Table(name = "TMilkshake")
public class Milkshake extends Alimento {

	private int tamanho;
	private boolean especial;
	private boolean chantily;

	public Milkshake() { super(); }
	
	public Milkshake(String nome, float preco, String sabor, int quantidade, int tamanho, boolean especial, boolean chantily) throws PrecoZeradoException {
		super(nome, preco, sabor, quantidade);
		this.tamanho = tamanho;
		this.especial = especial;
		this.chantily = chantily;
	}
	
	@Override
	public float calcularValorVenda() throws TamanhoMilkshakeInvalidoException {
		
		if (tamanho < 300) {
			throw new TamanhoMilkshakeInvalidoException ("O tamanho do milkshake está inválido!");
		}
		
		float valorEspecial = especial ? 5 : 0;
		float valorTamanho = tamanho * 0.05f;
		float valorChantily = chantily ? 2 : 0;
		
		return getPreco() + valorEspecial + valorTamanho + valorChantily;
	}
	
	public int		getTamanho() {
		return tamanho;
	}
	public void		setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public boolean	isEspecial() {
		return especial;
	}
	public void		setEspecial(boolean especial) {
		this.especial = especial;
	}
	public boolean	isChantily() {
		return chantily;
	}
	public void		setChantily(boolean chantily) {
		this.chantily = chantily;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(especial ? "especial=S" : "especial=N");
		sb.append(";");
		sb.append(chantily ? "chantily=S" : "chantily=N");
		sb.append(";");

		return sb.toString();
	}
}
