package br.com.solutis.locadora.repository;

import br.com.solutis.locadora.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    boolean existsByFilmeIdAndDevolvidoFalse(Long id);
}
