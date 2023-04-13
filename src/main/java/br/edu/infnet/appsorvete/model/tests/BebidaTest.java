package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Bebida;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoBebidaInvalidoException;

public class BebidaTest {

	public static void main(String[] args) {

		try {
			Bebida b1 = new Bebida("Bebida", 5, "cola", 1, "coca", 500, false);
			System.out.println(b1);
			System.out.println("Valor da Venda = R$" + b1.calcularValorVenda());
		} catch (TamanhoBebidaInvalidoException | PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		try {
			Bebida b2 = new Bebida("Bebida", 0, "Chopp", 1, "Bhrama", 500, true);
			System.out.println(b2);
			System.out.println("Valor da Venda = R$" + b2.calcularValorVenda());
		} catch (TamanhoBebidaInvalidoException | PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		try {
			Bebida b3 = new Bebida("Bebida", -5, "laranjinha", 1, "Schin-mini", 250, false);
			System.out.println(b3);
			System.out.println("Valor da Venda = R$" + b3.calcularValorVenda());
		} catch (TamanhoBebidaInvalidoException | PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

	}
}
