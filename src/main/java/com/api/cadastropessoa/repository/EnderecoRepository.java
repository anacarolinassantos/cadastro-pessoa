package com.api.cadastropessoa.repository;

import com.api.cadastropessoa.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
//    @Query(value = "SELECT * FROM endereco WHERE endereco = :endereco", nativeQuery = true)
//    Optional<Endereco> findByEndereco(@Param("endereco") String endereco);
}
