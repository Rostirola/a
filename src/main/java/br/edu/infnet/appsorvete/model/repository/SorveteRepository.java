package br.edu.infnet.appsorvete.model.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appsorvete.model.domain.Sorvete;

@Repository
public interface SorveteRepository extends CrudRepository<Sorvete, Integer> {

	@Query("from Sorvete s where s.usuario.id = :userId")
	List<Sorvete> obterLista(Integer userId);
}