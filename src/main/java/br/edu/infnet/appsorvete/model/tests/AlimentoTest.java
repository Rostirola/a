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
			Bebida b1 = new Bebida("Bebida", 5, "cola", 1, "coca", 500, false);
			System.out.println(b1);
			System.out.println("Valor da Venda = R$" + b1.calcularValorVenda());
		} catch (TamanhoBebidaInvalidoException | PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		try {
			Milkshake m1 = new Milkshake("Milkshake", 5, "morango", 3, 500, false, true);
			System.out.println(m1);
			System.out.println("Valor da Venda = R$" + m1.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		try {
			Sorvete s1 = new Sorvete("Sorvete", 5, "misto", 1, "casquinha", 300, true);
			System.out.println(s1);
			System.out.println("Valor da Venda = R$" + s1.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
	}
}
