package br.edu.infnet.appsorvete.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appsorvete.model.domain.Alimento;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.repository.AlimentoRepository;

@Service
public class AlimentoService {

	@Autowired
	private AlimentoRepository alimentoRepository;

	public void excluir(Integer id) {
		alimentoRepository.deleteById(id);
	}
	
	public Collection<Alimento> obterLista(){
		return (Collection<Alimento>) alimentoRepository.findAll();
	}
	
	public Collection<Alimento> obterLista(Usuario usuario){
		return (Collection<Alimento>) alimentoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Alimento obterPorId(Integer id) {
		return alimentoRepository.findById(id).orElse(null);
	}
}