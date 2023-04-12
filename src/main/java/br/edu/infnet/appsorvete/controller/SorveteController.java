package br.edu.infnet.appsorvete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appsorvete.model.domain.Sorvete;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.service.SorveteService;

@Controller
public class SorveteController {
	
	@Autowired
	private SorveteService sorveteService;

	private String msg;

	@GetMapping(value = "/sorvete")
	public String telaCadastro() {
		return "sorvete/cadastro";
	}	

	@GetMapping(value = "/sorvete/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("sorvetes", sorveteService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "sorvete/lista";
	}
	
	@PostMapping(value = "/sorvete/incluir")
	public String incluir(Sorvete sorvete, @SessionAttribute("usuario") Usuario usuario) {
		
		sorvete.setUsuario(usuario);

		sorveteService.incluir(sorvete);
		
		msg = "A inclusão da sorvete "+sorvete.getNome()+ sorvete.getTipo() + sorvete.getSabor() + sorvete.getTamanho()+" foi realizada com sucesso!!!";
		
		return "redirect:/sorvete/lista";
	}
		
	@GetMapping(value = "/sorvete/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Sorvete sorvete = sorveteService.obterPorId(id);
		
		try {
			sorveteService.excluir(id);

			msg = "A exclusão do produto "+sorvete.getNome()+ sorvete.getTipo() + sorvete.getSabor() + sorvete.getTamanho()+" foi realizada com sucesso!!!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do produto "+sorvete.getNome()+ sorvete.getTipo() + sorvete.getSabor() + sorvete.getTamanho()+"!!!";
		}

		return "redirect:/sorvete/lista";
	}
}