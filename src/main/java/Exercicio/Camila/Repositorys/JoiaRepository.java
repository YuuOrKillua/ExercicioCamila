package Exercicio.Camila.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Exercicio.Camila.Models.Joia;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, Long> {
    List<Joia> findAllByTipo(String tipo);
}