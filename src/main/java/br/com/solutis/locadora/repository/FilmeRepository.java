package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    boolean existsByTituloIgnoreCaseAndDiretorIgnoreCase(String titulo, String diretor);
}
