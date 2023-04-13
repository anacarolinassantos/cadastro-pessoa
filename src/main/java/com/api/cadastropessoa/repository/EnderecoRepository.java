package com.api.cadastropessoa.repository;

import com.api.cadastropessoa.entity.Endereco;
import com.api.cadastropessoa.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e FROM Endereco e WHERE e.principal IS TRUE")
    List<EnderecoModel> findByEnderecoPrincipal(Boolean principal);

}
