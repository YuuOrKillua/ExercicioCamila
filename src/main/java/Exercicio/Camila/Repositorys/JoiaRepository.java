package Exercicio.Camila.Repositorys;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Exercicio.Camila.Models.Joia;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, Long> {
    @Query("SELECT j FROM Joia j WHERE j.tipo = :tipo")
    List<Joia> findAllByTipo(@Param("tipo") String tipo);
}