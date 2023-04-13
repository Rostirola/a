package br.edu.infnet.appsorvete.controller;

import br.edu.infnet.appsorvete.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appsorvete.model.domain.Pedido;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.service.AlimentoService;
import br.edu.infnet.appsorvete.model.service.PedidoService;
import br.edu.infnet.appsorvete.model.service.ClienteService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private AlimentoService alimentoService;

	private String msg;

	@GetMapping(value = "/pedido")
	public String telaCadastro(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("clientes", clienteService.obterLista(usuario));

		model.addAttribute("alimentos", alimentoService.obterLista(usuario));
		return "pedido/cadastro";
	}	

	@GetMapping(value = "/pedido/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("pedidos", pedidoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "pedido/lista";
	}
	
	@PostMapping(value = "/pedido/incluir")
	public String incluir(Pedido pedido, Endereco endereco, @SessionAttribute("usuario") Usuario usuario) {

		usuario.setEndereco(endereco);

		pedido.setUsuario(usuario);

		pedidoService.incluir(pedido);
		
		msg = "A inclusão do pedido "+ pedido.getId() +" foi realizada com sucesso!!!";
		
		return "redirect:/pedido/lista";
	}
		
	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Pedido pedido = pedidoService.obterPorId(id);
		
		pedidoService.excluir(id);
		
		msg = "A exclusão do pedido "+ pedido.getId() +" foi realizada com sucesso!!!";

		return "redirect:/pedido/lista";
	}
}