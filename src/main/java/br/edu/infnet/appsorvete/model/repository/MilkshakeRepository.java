package br.edu.infnet.appsorvete.model.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appsorvete.model.domain.Milkshake;

@Repository
public interface MilkshakeRepository extends CrudRepository<Milkshake, Integer> {

	@Query("from Milkshake s where s.usuario.id = :userId")
	List<Milkshake> obterLista(Integer userId);
}