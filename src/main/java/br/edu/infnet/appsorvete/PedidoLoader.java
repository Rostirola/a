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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Order(6)
@Component
public class PedidoLoader implements ApplicationRunner {

    @Autowired
    private PedidoService pedidoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Pedido pedido = new Pedido();
        pedido.setComentario("Pedido um");
        pedido.setDinheiro(true);
        pedido.setData(LocalDateTime.now());

        Usuario usuario = new Usuario();
        usuario.setId(1);

        pedido.setUsuario(usuario);

        Cliente cliente = new Cliente();
        cliente.setId(1);

        pedido.setCliente(cliente);

        Bebida bebida = new Bebida();
        bebida.setId(5);

        Milkshake milkshake = new Milkshake();
        milkshake.setId(5);

        Sorvete sorvete = new Sorvete();
        sorvete.setId(5);

        List<Alimento> alimentos = new ArrayList<Alimento>();
        alimentos.add(bebida);
        alimentos.add(milkshake);
        alimentos.add(sorvete);

        pedido.setAlimentos(alimentos);

    }
}
