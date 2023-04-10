package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Bebida;
import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoMilkshakeInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoSorveteInvalidoException;

public class AlimentoTest {

	public static void main(String[] args) {

		try {
			Bebida b1 = new Bebida(12, "cola", 1, "cocacola");
			b1.setTamanho(500);
			b1.setAlcoolico(false);
			System.out.println(b1);
			System.out.println("Valor da Venda = R$" + b1.calcularValorVenda());
		} catch (TamanhoBebidaInvalidoException | PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		try {
			Milkshake m1 = new Milkshake(0, "morango", 3, 500);
			m1.setEspecial(false);
			m1.setChantily(true);
			System.out.println(m1);
			System.out.println("Valor da Venda = R$" + m1.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		try {
			Sorvete s1 = new Sorvete(5, "misto", 1, "casquinha");
			s1.setTamanho(300);
			s1.setTooping(true);
			System.out.println(s1);
			System.out.println("Valor da Venda = R$" + s1.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
	}
}
