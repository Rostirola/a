package br.edu.infnet.appsorvete;
 
import br.edu.infnet.appsorvete.model.domain.Cliente;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(6)
@Component
public class BebidaLoader implements ApplicationRunner {

	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "bebidas.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while(linha != null) {

					campos = linha.split(";");

					Bebida bebida = new Bebida(
							campos[0],
							Float.parseFloat(campos[1]),
							campos[2],
							Integer.parseInt(campos[3]),
							campos[4],
							Float.parseFloat(campos[5]),
							Boolean.parseBoolean(campos[6])
					);

					Usuario usuario = new Usuario();
					usuario.setId(1);

					bebida.setUsuario(usuario);

					bebidaService.incluir(bebida);

					System.out.println("A inclusão do cliente "+bebida.getNome()+" foi realizada com sucesso!!!");

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