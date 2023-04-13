package br.edu.infnet.appsorvete.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appsorvete.model.domain.Alimento;
import br.edu.infnet.appsorvete.model.domain.Bebida;
import br.edu.infnet.appsorvete.model.domain.Cliente;
import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.domain.Pedido;
import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.PedidoSemAlimentoException;
import br.edu.infnet.appsorvete.model.exceptions.PedidoSemSolicitanteException;
import br.edu.infnet.appsorvete.model.exceptions.PrecoZeradoException;

public class ArquivoTest {

	public static void main(String[] args) {

		try {
			String arq = "arquivo.txt";

			try {

				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				FileWriter fileW = new FileWriter("out_" + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);

				String linha = leitura.readLine();

				String[] campos = null;

				List<Alimento> alimentos = new ArrayList<Alimento>();
				Pedido pedido = null;

				while (linha != null) {

					campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "P":
						try {
							pedido = new Pedido(new Cliente(campos[3], (campos[4]),
									(campos[5]), campos[6]), alimentos);
							pedido.setComentario(campos[1]);
							pedido.setDinheiro(Boolean.parseBoolean(campos[2]));
						} catch (ClienteInvalidoException | PedidoSemSolicitanteException
								| PedidoSemAlimentoException e) {
							System.out.println("[ERRO]" + e.getMessage());
						}

						break;
					case "S":
						try {
							Sorvete sorvete = new Sorvete(campos[1],
									Float.parseFloat(campos[2]),
									campos[3],
									Integer.parseInt(campos[4]),
									campos[5],
									Integer.parseInt(campos[6]),
									Boolean.parseBoolean(campos[7]));
							alimentos.add(sorvete);
						} catch (PrecoZeradoException e) {
							System.out.println("[ERRO}" + e.getMessage());
						}

						break;
					case "M":
						try {
							Milkshake milkshake = new Milkshake(campos[1],
									Float.parseFloat(campos[2]),
									campos[3],
									Integer.parseInt(campos[4]),
									Integer.parseInt(campos[5]),
									Boolean.parseBoolean(campos[6]),
									Boolean.parseBoolean(campos[7]));
							alimentos.add(milkshake);
						} catch (PrecoZeradoException e) {
							System.out.println("[ERRO}" + e.getMessage());
						}
						break;
					case "B":
						try {
							Bebida bebida = new Bebida(campos[1],
									Float.parseFloat(campos[2]),
									campos[3],
									Integer.parseInt(campos[4]),
									campos[5],
									Float.parseFloat(campos[6]),
									Boolean.parseBoolean(campos[7]));
							alimentos.add(bebida);
						} catch (PrecoZeradoException e) {
							System.out.println("[ERRO}" + e.getMessage());
						}
						break;
					default:
						System.out.println("Registro inválido!!!");
						break;
					}

					linha = leitura.readLine();
				}

				if (pedido != null) {
					escrita.write(pedido.obterLinha());
				}

				escrita.write(pedido.obterLinha());

				escrita.close();

				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO]" + e.getMessage());
			}
		} finally {
			System.out.println("Processamento realizado com sucesso!");
		}

	}

}
