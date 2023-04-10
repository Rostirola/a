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

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Cliente cliente = new Cliente();
		cliente.setId(1);
		Cliente cliente2 = new Cliente();
		cliente.setId(2);
		Cliente cliente3 = new Cliente();
		cliente.setId(3);

		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);



		
		Usuario userFunc = new Usuario("Funcionario ", "func@func.com", "123");
		userFunc.setIdade(99);
		userFunc.setSalario(9999);
		userFunc.setSetor("Producao");
		userFunc.setTipo("Func");
		userFunc.setFunc(true);
		//userFunc.setClientes(clientes);

		usuarioService.incluir(userFunc);
		
		System.out.println("Inclusão do funcionario "+userFunc.getNome()+" realizada com sucesso!!!");
		
		for (int i = 0; i < 9; i++) {
			Usuario usuario = new Usuario("Funcionario " + i, "func"+i+"@func.com", "0"+i);
			usuario.setIdade(i*4);
			usuario.setSalario(i*100);
			usuario.setSetor("Presidência " + i);
			usuario.setTipo("Func " + i);
			//userFunc.setClientes(clientes);

			usuarioService.incluir(usuario);
			
			System.out.println("Inclusão do usuário "+usuario.getNome()+" realizada com sucesso!!!");
		}

	}
}