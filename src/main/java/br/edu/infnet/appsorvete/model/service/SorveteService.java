package br.edu.infnet.appsorvete.model.service;
 
import java.util.Collection;

import br.edu.infnet.appsorvete.model.domain.Bebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.repository.SorveteRepository;

@Service
public class SorveteService {
	
	@Autowired
	private SorveteRepository sorveteRepository;
	
	public Sorvete incluir(Sorvete sorvete) {
		return sorveteRepository.save(sorvete);
	}
	
	public void excluir(Integer id) {
		sorveteRepository.deleteById(id);
	}
	
	public Collection<Sorvete> obterLista(){
		return (Collection<Sorvete>) sorveteRepository.findAll();
	}
	
	public Collection<Sorvete> obterLista(Usuario usuario){
		return (Collection<Sorvete>) sorveteRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Sorvete obterPorId(Integer id) {
		return sorveteRepository.findById(id).orElse(null);
	}
}