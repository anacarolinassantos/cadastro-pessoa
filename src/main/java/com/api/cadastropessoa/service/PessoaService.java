package com.api.cadastropessoa.service;

import com.api.cadastropessoa.model.PessoaModel;
import java.util.List;

public interface PessoaService {

    List<PessoaModel> consultar();

    PessoaModel consultarPorId(Long id);

    PessoaModel cadastrar(PessoaModel model);

    PessoaModel alterar(PessoaModel model);

    void excluir(Long id);
}
