package br.edu.infnet.appsorvete.model.service;

import java.util.Collection;

import br.edu.infnet.appsorvete.model.domain.Bebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
 
import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.repository.MilkshakeRepository;

@Service
public class MilkshakeService {
	
	@Autowired
	private MilkshakeRepository milkshakeRepository;
	
	public Milkshake incluir(Milkshake milkshake) {
		return milkshakeRepository.save(milkshake);
	}
	
	public void excluir(Integer id) {
		milkshakeRepository.deleteById(id);
	}
	
	public Collection<Milkshake> obterLista(){
		return (Collection<Milkshake>) milkshakeRepository.findAll();
	}
	
	public Collection<Milkshake> obterLista(Usuario usuario){
		return (Collection<Milkshake>) milkshakeRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Milkshake obterPorId(Integer id) {
		return milkshakeRepository.findById(id).orElse(null);
	}
}