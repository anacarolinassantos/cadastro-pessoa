package com.api.cadastropessoa.entity;

import com.api.cadastropessoa.model.EnderecoModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "logradouro")
    private String logradouro;

    @NotNull
    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private Integer numero;

    @NotNull
    @Column(name = "cidade")
    private String cidade;

    @NotNull
    @Column(name = "principal")
    private Boolean principal;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco(EnderecoModel model) {
        this.logradouro = model.getLogradouro();
        this.cep = model.getCep();
        this.numero = model.getNumero();
        this.cidade = model.getCidade();
        this.principal = model.getPrincipal();
    }

    public Endereco editar(EnderecoModel model) {
        this.logradouro = model.getLogradouro();
        this.cep = model.getCep();
        this.numero = model.getNumero();
        this.cidade = model.getCidade();
        this.principal = model.getPrincipal();
        return this;
    }
}
