package br.edu.infnet.appsorvete;
 
import br.edu.infnet.appsorvete.model.domain.Bebida;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(4)
@Component
public class MilkshakeLoader implements ApplicationRunner {

	@Autowired
	private MilkshakeService milkshakeService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "milkshakes.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while(linha != null) {

					campos = linha.split(";");

					Milkshake milkshake = new Milkshake(
							campos[0],
							Float.parseFloat(campos[1]),
							campos[2],
							Integer.parseInt(campos[3]),
							Integer.parseInt(campos[4]),
							Boolean.parseBoolean(campos[5]),
							Boolean.parseBoolean(campos[6])
					);

					Usuario usuario = new Usuario();
					usuario.setId(1);

					milkshake.setUsuario(usuario);

					milkshakeService.incluir(milkshake);

					System.out.println("A inclusão do cliente "+milkshake.getNome()+" foi realizada com sucesso!!!");

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