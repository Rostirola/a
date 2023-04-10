package br.edu.infnet.appsorvete;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoMilkshakeInvalidoException;
import br.edu.infnet.appsorvete.model.service.MilkshakeService;

@Order(4)
@Component
public class MilkshakeLoader implements ApplicationRunner {

	@Autowired
	private MilkshakeService milkshakeService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario userFunc = new Usuario();
		userFunc.setId(1);
        
		try {
			Milkshake milkshake = new Milkshake(5, "ovomaltine", 1, 500);
			milkshake.setEspecial(false);
			milkshake.setTamanho(500);
			milkshake.setUsuario(userFunc);
			System.out.println(milkshake);
			System.out.println("Valor de Venda = R$" + milkshake.calcularValorVenda());
	
			milkshakeService.incluir(milkshake);
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	
		try {
			Milkshake milkshake = new Milkshake(5, "ovomaltine", 1, 500);
			milkshake.setEspecial(false);
			milkshake.setTamanho(500);
			milkshake.setUsuario(userFunc);
			System.out.println(milkshake);
			System.out.println("Valor de Venda = R$" + milkshake.calcularValorVenda());
	
			milkshakeService.incluir(milkshake);
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	
		try {
			Milkshake milkshake = new Milkshake(5, "ovomaltine", 1, 500);
			milkshake.setEspecial(false);
			milkshake.setTamanho(500);
			System.out.println(milkshake);
			milkshake.setUsuario(userFunc);
			System.out.println("Valor de Venda = R$" + milkshake.calcularValorVenda());
	
			milkshakeService.incluir(milkshake);
		} catch (PrecoZeradoException | TamanhoMilkshakeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		System.out.println("Listagem de Milkshakes:");
		for(Milkshake milkshake : milkshakeService.obterLista()) {
			System.out.printf("%d - %s - %s\n", 
					milkshake.getId(),
					milkshake.getSabor(),
					milkshake.isEspecial()
			);
		}
	}
}