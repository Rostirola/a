package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoMilkshakeInvalidoException;

public class MilkshakeTest {

	public static void main(String[] args) {

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
			Milkshake m2 = new Milkshake(-8, "napolitano", 5, 300);
			m2.setEspecial(false);
			m2.setChantily(true);
			System.out.println(m2);
			System.out.println("Valor da Venda = R$" + m2.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

		try {
			Milkshake m3 = new Milkshake(20, "nutella", 1, 1000);
			m3.setEspecial(true);
			m3.setChantily(false);
			System.out.println(m3);
			System.out.println("Valor da Venda = R$" + m3.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

	}
}
