package com.api.cadastropessoa.entity;

import com.api.cadastropessoa.model.PessoaModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "data_nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

    public Pessoa(PessoaModel model) {
        this.nome = model.getNome();
        this.dataNascimento = model.getDataNascimento();
        this.enderecos = model.getEndereco().stream().map(Endereco::new).collect(Collectors.toList());
    }

    public Pessoa editar(PessoaModel model) {
        this.id = model.getId();
        this.nome = model.getNome().trim();
        this.dataNascimento = model.getDataNascimento();
        this.enderecos = model.getEndereco().stream().map(Endereco::new).collect(Collectors.toList());
        return this;
    }
}
