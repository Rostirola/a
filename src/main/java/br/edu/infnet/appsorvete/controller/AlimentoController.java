package br.edu.infnet.appsorvete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appsorvete.model.domain.Alimento;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.service.AlimentoService;

@Controller
public class AlimentoController {

	@Autowired
	private AlimentoService alimentoService;

	private String msg;

	@GetMapping(value = "/alimento/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("alimentos", alimentoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);

		msg = null;

		return "alimento/lista";
	}

	@GetMapping(value = "/alimento/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Alimento alimento = alimentoService.obterPorId(id);

		try {
			alimentoService.excluir(id);

			msg = "A exclusão do alimento "+alimento.getNome()+" foi realizada com sucesso!!!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do alimento "+alimento.getNome()+"!!!";
		}

		return "redirect:/alimento/lista";
	}
}