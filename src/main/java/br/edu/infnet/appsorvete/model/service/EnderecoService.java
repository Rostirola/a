package br.edu.infnet.appsorvete.model.service;

import br.edu.infnet.appsorvete.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appsorvete.clients.IEnderecoClient;
import br.edu.infnet.appsorvete.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco buscaPorCep(String cep) {

		return enderecoClient.buscaPorCep(cep);
	}
}