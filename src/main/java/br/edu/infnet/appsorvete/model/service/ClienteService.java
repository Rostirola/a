package br.edu.infnet.appsorvete.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appsorvete.model.domain.Cliente;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente incluir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Integer key) {
		clienteRepository.deleteById(key);
	}
	
	public Collection<Cliente> obterLista(){
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> obterLista(Usuario usuario){
		return clienteRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "nome"));
	}
}