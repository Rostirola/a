package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoSorveteInvalidoException;

public class SorveteTest {

	public static void main(String[] args) {

		try {
			Sorvete s1 = new Sorvete("Sorvete", 5, "misto", 1, "casquinha", 300, true);
			System.out.println(s1);
			System.out.println("Valor da Venda = R$" + s1.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

		try {
			Sorvete s2 = new Sorvete("Sorvete", 5, "natagoiaba", 1, "casquinha", 300, true);
			System.out.println(s2);
			System.out.println("Valor da Venda = R$" + s2.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

		try {
			Sorvete s3 = new Sorvete("Sorvete", 5, "acaibanana", 1, "casquinha", 300, true);
			System.out.println(s3);
			System.out.println("Valor da Venda = R$" + s3.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

	}
}
