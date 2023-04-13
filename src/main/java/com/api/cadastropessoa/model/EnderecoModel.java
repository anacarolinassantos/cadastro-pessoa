package com.api.cadastropessoa.model;

import com.api.cadastropessoa.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class EnderecoModel {

    private Long id;

    private String logradouro;

    private String cep;

    private Integer numero;

    private String cidade;

    private Boolean principal;

    private PessoaModel pessoaModel;

    public EnderecoModel(Endereco endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.principal = endereco.getPrincipal();
    }
}
