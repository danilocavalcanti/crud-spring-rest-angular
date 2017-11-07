package crud.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.rest.model.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

	Plano findById(Long id);
}
