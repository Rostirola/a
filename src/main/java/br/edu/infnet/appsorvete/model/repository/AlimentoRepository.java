package br.edu.infnet.appsorvete.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appsorvete.model.domain.Alimento;

@Repository
public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {

	@Query("from Alimento p where p.usuario.id = :userId")
	List<Alimento> obterLista(Integer userId);
}