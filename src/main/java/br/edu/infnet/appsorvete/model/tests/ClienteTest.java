package br.edu.infnet.appsorvete.model.tests;

import br.edu.infnet.appsorvete.model.domain.Cliente;
import br.edu.infnet.appsorvete.model.exceptions.ClienteInvalidoException;

public class ClienteTest {

	public static void main(String[] args) {
		
		
		try {
			Cliente c1 = new Cliente("Juan", "947392017", "22", "juan@gmail.com");
			System.out.println(c1);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		try {
		Cliente c2 = new Cliente(null, "938503783", "17", "juliana@gmail.com");
		System.out.println(c2);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
		
		try {
		Cliente c3 = new Cliente("Elbert", "10", "-30", null);
		System.out.println(c3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO}" + e.getMessage());
		}
	}
}
