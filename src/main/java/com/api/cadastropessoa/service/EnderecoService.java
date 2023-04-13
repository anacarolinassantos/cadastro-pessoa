package com.api.cadastropessoa.service;

import com.api.cadastropessoa.model.EnderecoModel;
import java.util.List;

public interface EnderecoService {
    List<EnderecoModel> consultar();

    EnderecoModel consultarPorId(Long id);

    List<EnderecoModel> consultarEndPrincipal(Boolean principal);

    EnderecoModel cadastrar(EnderecoModel model);

    EnderecoModel alterar(EnderecoModel model);

    void excluir(Long id);
}
