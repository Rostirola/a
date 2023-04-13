package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoMilkshakeInvalidoException;

public class MilkshakeTest {

	public static void main(String[] args) {

		try {
			Milkshake m1 = new Milkshake("Milkshake", 0, "morango", 3, 500, false, true);
			System.out.println(m1);
			System.out.println("Valor da Venda = R$" + m1.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

		try {
			Milkshake m2 = new Milkshake("Milkshake", -3, "morango", 3, 500, false, true);
			System.out.println(m2);
			System.out.println("Valor da Venda = R$" + m2.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

		try {
			Milkshake m3 = new Milkshake("Milkshake", 20, "nutela", 3, 500, true, true);
			m3.setEspecial(true);
			m3.setChantily(false);
			System.out.println(m3);
			System.out.println("Valor da Venda = R$" + m3.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

	}
}
