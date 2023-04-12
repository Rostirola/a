package br.edu.infnet.appsorvete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.infnet.appsorvete.model.domain.Usuario;
import br.edu.infnet.appsorvete.model.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
	private UsuarioService usuarioService;

    private String msg;

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";}

    @GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("usuarios", usuarioService.obterListaOrdenada());
		
		model.addAttribute("mensagem", msg);

        msg = null;		
		
		return "usuario/lista";
	}

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {

        usuarioService.incluir(usuario);

        msg = "A inclusão fo usuário" + usuario.getNome() + "foi realizada com sucesso!";

        return "redirect:/";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
        public String excluir(@PathVariable Integer id) {
            
            usuarioService.excluir(id);

            msg = "A exclusão do usuário foi realizada com sucesso!";

            return "redirect:/usuario/lista";
        }
    
    
}
