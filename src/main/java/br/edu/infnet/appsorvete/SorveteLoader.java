package br.edu.infnet.appsorvete;
 
import br.edu.infnet.appsorvete.model.domain.Bebida;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(4)
@Component
public class SorveteLoader implements ApplicationRunner {

	@Autowired
	private SorveteService sorveteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "sorvetes.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while(linha != null) {

					campos = linha.split(";");

					Sorvete sorvete = new Sorvete(
							campos[0],
							Float.parseFloat(campos[1]),
							campos[2],
							Integer.parseInt(campos[3]),
							campos[4],
							Integer.parseInt(campos[5]),
							Boolean.parseBoolean(campos[6])
					);

					Usuario usuario = new Usuario();
					usuario.setId(1);

					sorvete.setUsuario(usuario);

					sorveteService.incluir(sorvete);

					System.out.println("A inclusão do cliente "+sorvete.getNome()+" foi realizada com sucesso!!!");

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
