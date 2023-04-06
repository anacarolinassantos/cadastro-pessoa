package com.api.cadastropessoa.service;


import com.api.cadastropessoa.model.EnderecoModel;

import java.util.List;


public interface EnderecoService {
    List<EnderecoModel> consultar();

    EnderecoModel consultarPorId(Long id);

    EnderecoModel cadastrar(EnderecoModel model);

    EnderecoModel alterar(EnderecoModel model);

    //    EnderecoModel enderecoPrincipal(Long pessoaId);
    void excluir(Long id);
}
