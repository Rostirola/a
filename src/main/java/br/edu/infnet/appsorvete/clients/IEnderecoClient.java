package br.edu.infnet.appsorvete.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appsorvete.model.domain.Endereco;

@Repository
@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IEnderecoClient extends CrudRepository<Endereco, Integer> {

	@GetMapping(value = "/{cep}/json")
	public Endereco buscaPorCep(@PathVariable String cep);
}