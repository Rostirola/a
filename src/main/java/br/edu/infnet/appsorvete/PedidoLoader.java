package br.edu.infnet.appsorvete;

import br.edu.infnet.appsorvete.model.domain.*;
import br.edu.infnet.appsorvete.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appsorvete.model.exceptions.PedidoSemAlimentoException;
import br.edu.infnet.appsorvete.model.exceptions.PedidoSemSolicitanteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appsorvete.model.service.PedidoService;

import java.util.ArrayList;
import java.util.List;

@Order(6)
@Component
public class PedidoLoader implements ApplicationRunner {

    @Autowired
    private PedidoService pedidoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1);

        Cliente cliente = new Cliente();
        cliente.setId(1);

        Pedido pedido = new Pedido();

        pedido.setDinheiro(true);
        pedido.setComentario("Pedido um");
        pedido.setUsuario(usuario);
        pedido.setCliente(cliente);

        Bebida bebida = new Bebida();
        bebida.setId(1);

        Milkshake milkshake = new Milkshake();
        milkshake.setId(1);

        Sorvete sorvete = new Sorvete();
        sorvete.setId(1);

        List<Alimento> alimentos = new ArrayList<Alimento>();
        alimentos.add(bebida);
        alimentos.add(milkshake);
        alimentos.add(sorvete);

        pedido.setAlimentos(alimentos);



    }
}
