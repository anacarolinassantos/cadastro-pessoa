package com.api.cadastropessoa.repository;

import com.api.cadastropessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
//    @Query(value = "SELECT * FROM pessoa WHERE nome = :nome", nativeQuery = true)
//    Optional<Pessoa> findByNome(@Param("nome") String nome);
}
