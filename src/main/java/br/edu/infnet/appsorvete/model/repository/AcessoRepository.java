package br.edu.infnet.appsorvete.model.repository;

import br.edu.infnet.appsorvete.model.domain.Usuario;

public class AcessoRepository {

	public static Usuario autenticar(Usuario usuario) {

		if(usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
			return new Usuario("Funcionario", usuario.getEmail(), usuario.getSenha());
		}

		return null;
	}
}
