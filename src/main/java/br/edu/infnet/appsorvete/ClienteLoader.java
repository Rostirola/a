package br.edu.infnet.appsorvete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.edu.infnet.appsorvete.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appsorvete.model.domain.Cliente;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.service.ClienteService;

@Order(3)
@Component
public class ClienteLoader implements ApplicationRunner {
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "clientes.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();			
				String[] campos = null;

				while(linha != null) {
					
					campos = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);

					Endereco endereco = new Endereco();
					
					Cliente cliente = new Cliente(
							campos[0],
							campos[1],
							campos[2],
							campos[3]
						);
					cliente.setUsuario(usuario);
					
					clienteService.incluir(cliente);

					System.out.println("A inclusão do cliente "+cliente.getNome()+" foi realizada com sucesso!!!");

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			} 
			
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}		
	}
}