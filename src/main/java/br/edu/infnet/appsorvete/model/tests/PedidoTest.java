package br.edu.infnet.appsorvete.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appsorvete.model.domain.Alimento;
import br.edu.infnet.appsorvete.model.domain.Bebida;
import br.edu.infnet.appsorvete.model.domain.Cliente;
import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.domain.Pedido;
import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.PedidoSemAlimentoException;
import br.edu.infnet.appsorvete.model.exceptions.PedidoSemSolicitanteException;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;

public class PedidoTest {

	public static void main(String[] args) {
		
		List<Alimento> alimentoP1 = new ArrayList<Alimento>();
		List<Alimento> alimentoP2 = new ArrayList<Alimento>();
		List<Alimento> alimentoP3 = new ArrayList<Alimento>();
		
		try {
			Bebida b1 = new Bebida(12, "cola", 1, "cocacola");
			b1.setTamanho(500);
			b1.setAlcoolico(false);
			alimentoP1.add(b1);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		try {
			Bebida b2 = new Bebida(0, "chopp", 5, "brahma");
			b2.setTamanho(473);
			b2.setAlcoolico(true);
			alimentoP3.add(b2);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		try {
			Bebida b3 = new Bebida(-2, "laranja", 2, "schin mini");
			b3.setTamanho(250);
			b3.setAlcoolico(false);
			alimentoP2.add(b3);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		try {
			Milkshake m1 = new Milkshake(0, "morango", 3, 500);
			m1.setEspecial(false);
			m1.setChantily(true);
			alimentoP2.add(m1);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		
		try {
			Milkshake m2 = new Milkshake(-8, "napolitano", 5, 300);
			m2.setEspecial(false);
			m2.setChantily(true);
			alimentoP3.add(m2);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		
		try {
			Milkshake m3 = new Milkshake(20, "nutella", 1, 1000);
			m3.setEspecial(true);
			m3.setChantily(false);
			alimentoP1.add(m3);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		try {
			Sorvete s1 = new Sorvete(5, "misto", 1, "casquinha");
			s1.setTamanho(300);
			s1.setTooping(true);
			alimentoP3.add(s1);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		
		try {
			Sorvete s2 = new Sorvete(8, "natagoiaba", 3, "cascao");
			s2.setTamanho(500);
			s2.setTooping(true);
			alimentoP2.add(s2);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		
		try {
			Sorvete s3 = new Sorvete(8, "acaibanana", 12, "cascao");
			s3.setTamanho(500);
			s3.setTooping(false);
			alimentoP1.add(s3);
		} catch (PrecoZeradoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		try {
		Pedido p1 = new Pedido(new Cliente("Juan", "947392017", "22", "juan@gmail.com"), alimentoP1);
		p1.setComentario("Primeiro pedido");
		p1.setDinheiro(false);
		p1.imprimir();
		} catch (ClienteInvalidoException | PedidoSemSolicitanteException | PedidoSemAlimentoException e) {
			System.out.println("[ERRO]" + e.getMessage());
		}

		try {
		Pedido p2 = new Pedido(new Cliente("Juan", "947392017", "22", "juan@gmail.com"), alimentoP2);
		p2.setComentario("Segundo pedido");
		p2.setDinheiro(true);
		p2.imprimir();
		} catch (ClienteInvalidoException | PedidoSemSolicitanteException | PedidoSemAlimentoException e) {
			System.out.println("[ERRO]" + e.getMessage());
		}

		try {
		Pedido p3 = new Pedido(new Cliente("Elbert", "10", "-30", null), alimentoP3);
		p3.setComentario("Terceiro pedido");
		p3.setDinheiro(false);
		p3.imprimir();
		} catch (ClienteInvalidoException | PedidoSemSolicitanteException | PedidoSemAlimentoException e) {
			System.out.println("[ERRO]" + e.getMessage());
		}
		
	}
}
