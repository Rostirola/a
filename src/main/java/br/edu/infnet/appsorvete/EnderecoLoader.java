package br.edu.infnet.appsorvete;


import br.edu.infnet.appsorvete.model.domain.Endereco;
import br.edu.infnet.appsorvete.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class EnderecoLoader implements ApplicationRunner {

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco endereco = new Endereco("98780738", "Av. Rio Branco", "Rei do milk shake", "Centro", "Santa Rosa", "Rs");

        enderecoService.incluir(endereco);
    }
}
