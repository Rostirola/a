package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoSorveteInvalidoException;

public class SorveteTest {

	public static void main(String[] args) {

		try {
			Sorvete s1 = new Sorvete(5, "misto", 1, "casquinha");
			s1.setTamanho(300);
			s1.setTooping(true);
			System.out.println(s1);
			System.out.println("Valor da Venda = R$" + s1.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

		try {
			Sorvete s2 = new Sorvete(8, "natagoiaba", 3, "cascao");
			s2.setTamanho(500);
			s2.setTooping(true);
			System.out.println(s2);
			System.out.println("Valor da Venda = R$" + s2.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

		try {
			Sorvete s3 = new Sorvete(8, "acaibanana", 12, "cascao");
			s3.setTamanho(500);
			s3.setTooping(false);
			System.out.println(s3);
			System.out.println("Valor da Venda = R$" + s3.calcularValorVenda());
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}

	}
}
