package br.edu.infnet.appsorvete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appsorvete.model.domain.Milkshake;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.service.MilkshakeService;

@Controller
public class MilkshakeController {
	
	@Autowired
	private MilkshakeService milkshakeService;

	private String msg;

	@GetMapping(value = "/milkshake")
	public String telaCadastro() {
		return "milkshake/cadastro";
	}	

	@GetMapping(value = "/milkshake/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("milkshakes", milkshakeService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "milkshake/lista";
	}
	
	@PostMapping(value = "/milkshake/incluir")
	public String incluir(Milkshake milkshake, @SessionAttribute("usuario") Usuario usuario) {
		
		milkshake.setUsuario(usuario);

		milkshakeService.incluir(milkshake);
		
		msg = "A inclusão da milkshake "+milkshake.getTamanho()+" foi realizada com sucesso!!!";
		
		return "redirect:/milkshake/lista";
	}
		
	@GetMapping(value = "/milkshake/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Milkshake milkshake = milkshakeService.obterPorId(id);
		
		try {
			milkshakeService.excluir(id);

			msg = "A exclusão do produto "+milkshake.getTamanho()+" foi realizada com sucesso!!!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do produto "+milkshake.getTamanho()+"!!!";
		}

		return "redirect:/milkshake/lista";
	}
}