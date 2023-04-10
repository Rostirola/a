package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Bebida;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoBebidaInvalidoException;

public class BebidaTest {

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
			Bebida b2 = new Bebida(0, "chopp", 5, "brahma");
			b2.setTamanho(200);
			b2.setAlcoolico(true);
			System.out.println(b2);
			System.out.println("Valor da Venda = R$" + b2.calcularValorVenda());
		} catch (TamanhoBebidaInvalidoException | PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		try {
			Bebida b3 = new Bebida(-2, "laranja", 2, "schin mini");
			b3.setTamanho(250);
			b3.setAlcoolico(false);
			System.out.println(b3);
			System.out.println("Valor da Venda = R$" + b3.calcularValorVenda());
		} catch (TamanhoBebidaInvalidoException | PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

	}
}
