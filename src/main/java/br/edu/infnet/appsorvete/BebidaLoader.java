package br.edu.infnet.appsorvete;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appsorvete.model.domain.Bebida;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;
import br.edu.infnet.appsorvete.model.service.BebidaService;

@Order(5)
@Component
public class BebidaLoader implements ApplicationRunner {

	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
        
        Usuario userFunc = new Usuario();
		userFunc.setId(1);
	

	try {
		Bebida bebida = new Bebida(5, "Cola", 1, "Coca-cola");
		bebida.setAlcoolico(false);
		bebida.setTamanho(500);
		bebida.setUsuario(userFunc);
		System.out.println(bebida);
		System.out.println("Valor de Venda = R$" + bebida.calcularValorVenda());

		bebidaService.incluir(bebida);
	} catch (PrecoZeradoException | TamanhoBebidaInvalidoException e) {
		System.out.println("[ERRO] " + e.getMessage());
	}

	try {
		Bebida bebida = new Bebida(5, "Cola", 1, "Coca-cola");
		bebida.setAlcoolico(false);
		bebida.setTamanho(500);
		bebida.setUsuario(userFunc);
		System.out.println(bebida);
		System.out.println("Valor de Venda = R$" + bebida.calcularValorVenda());

		bebidaService.incluir(bebida);
	} catch (PrecoZeradoException | TamanhoBebidaInvalidoException e) {
		System.out.println("[ERRO] " + e.getMessage());
	}

	try {
		Bebida bebida = new Bebida(5, "Cola", 1, "Coca-cola");
		bebida.setAlcoolico(false);
		bebida.setTamanho(500);
		System.out.println(bebida);
		bebida.setUsuario(userFunc);
		System.out.println("Valor de Venda = R$" + bebida.calcularValorVenda());

		bebidaService.incluir(bebida);
	} catch (PrecoZeradoException | TamanhoBebidaInvalidoException e) {
		System.out.println("[ERRO] " + e.getMessage());
	}
	
	System.out.println("Listagem de Bebidas:");
	for(Bebida bebida : bebidaService.obterLista()) {
		System.out.printf("%d - %s - %s\n", 
				bebida.getId(),
				bebida.getSabor(),
				bebida.getMarca()
			);
		}
	}

}