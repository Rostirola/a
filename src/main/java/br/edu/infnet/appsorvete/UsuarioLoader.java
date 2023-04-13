package br.edu.infnet.appsorvete;
 
import br.edu.infnet.appsorvete.model.domain.Alimento;
import br.edu.infnet.appsorvete.model.domain.Cliente;
import br.edu.infnet.appsorvete.model.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

@Order(2)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario userFunc = new Usuario("Funcionario ", "func@func.com", "123");
		userFunc.setIdade(99);
		userFunc.setSalario(9999);
		userFunc.setSetor("Producao");
		userFunc.setTipo("Func");
		userFunc.setFunc(true);
		userFunc.setCaracteristica("Estoque");
		

		usuarioService.incluir(userFunc);
		
		System.out.println("Inclusão do funcionario "+userFunc.getNome()+" realizada com sucesso!!!");
		
		for (int i = 0; i < 9; i++) {
			Usuario usuario = new Usuario("Funcionario " + i, "func"+i+"@func.com", "0"+i);
			usuario.setIdade(i*4);
			usuario.setSalario(i*100);
			usuario.setSetor("Presidência " + i);
			usuario.setTipo("Func " + i);
			usuario.setCaracteristica("Estoque" + i);

			usuarioService.incluir(usuario);
			
			System.out.println("Inclusão do usuário "+usuario.getNome()+" realizada com sucesso!!!");
		}

	}
}