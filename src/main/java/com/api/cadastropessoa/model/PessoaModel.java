package com.api.cadastropessoa.model;

import com.api.cadastropessoa.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class PessoaModel {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private List<EnderecoModel> endereco;

    public PessoaModel(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.endereco = pessoa.getEnderecos().stream().map(EnderecoModel::new).collect(Collectors.toList());
    }
}
