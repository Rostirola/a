package br.edu.infnet.appsorvete.model.service;

import java.util.Collection;

import br.edu.infnet.appsorvete.model.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario autenticar(Usuario usuario) {
		return usuarioRepository.autenticacao(usuario.getEmail(), usuario.getSenha());
	}

	public Usuario incluir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Integer key) {
		usuarioRepository.deleteById(key);
	}
	
	public Collection<Usuario> obterLista(){
		return (Collection<Usuario>) usuarioRepository.findAll();
	}

	public Collection<Usuario> obterListaOrdenada() { return (Collection<Usuario>) usuarioRepository.obterListaOrdenada(Sort.by(Sort.Direction.ASC, "nome"));}

	public Usuario obterPorId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
}