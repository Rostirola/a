package br.edu.infnet.appsorvete.model.service;

import java.util.Collection;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appsorvete.model.domain.Bebida;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.repository.BebidaRepository;

@Service
public class BebidaService {
	
	@Autowired
	private BebidaRepository bebidaRepository;
	
	public Bebida incluir(Bebida bebida) {
		return bebidaRepository.save(bebida);
	}
	
	public void excluir(Integer id) {
		bebidaRepository.deleteById(id);
	}
	
	public Collection<Bebida> obterLista(){
		return (Collection<Bebida>) bebidaRepository.findAll();
	}
	
	public Collection<Bebida> obterLista(Usuario usuario){
		return bebidaRepository.obterLista(usuario.getId());
	}

	public Bebida obterPorId(Integer id) {
		return bebidaRepository.findById(id).orElse(null);
	}
}