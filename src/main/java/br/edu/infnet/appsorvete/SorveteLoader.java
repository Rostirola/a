package br.edu.infnet.appsorvete;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoSorveteInvalidoException;
import br.edu.infnet.appsorvete.model.service.SorveteService;

@Order(3)
@Component
public class SorveteLoader implements ApplicationRunner {

	@Autowired
	private SorveteService sorveteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario userFunc = new Usuario();
		userFunc.setId(1);

		try {
			Sorvete sorvete = new Sorvete(5, "Morango", 1, "Casquinha");
			sorvete.setTooping(false);
			sorvete.setTamanho(500);
			sorvete.setUsuario(userFunc);
			System.out.println(sorvete);
			System.out.println("Valor de Venda = R$" + sorvete.calcularValorVenda());
	
			sorveteService.incluir(sorvete);
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	
		try {
			Sorvete sorvete = new Sorvete(5, "Morango", 1, "Casquinha");
			sorvete.setTooping(false);
			sorvete.setTamanho(500);
			sorvete.setUsuario(userFunc);
			System.out.println(sorvete);
			System.out.println("Valor de Venda = R$" + sorvete.calcularValorVenda());
	
			sorveteService.incluir(sorvete);
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	
		try {
			Sorvete sorvete = new Sorvete(5, "Morango", 1, "Casquinha");
			sorvete.setTooping(false);
			sorvete.setTamanho(500);
			System.out.println(sorvete);
			sorvete.setUsuario(userFunc);
			System.out.println("Valor de Venda = R$" + sorvete.calcularValorVenda());
	
			sorveteService.incluir(sorvete);
		} catch (PrecoZeradoException | TamanhoSorveteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		System.out.println("Listagem de Sorvetes:");
		for(Sorvete sorvete : sorveteService.obterLista()) {
			System.out.printf("%d - %s - %s\n", 
					sorvete.getId(),
					sorvete.getSabor(),
					sorvete.getTipo()
			);
		}
	}
}
