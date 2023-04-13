package com.api.cadastropessoa.service.impl;

import com.api.cadastropessoa.entity.Endereco;
import com.api.cadastropessoa.exception.RegistroNaoIdentificadoException;
import com.api.cadastropessoa.model.EnderecoModel;
import com.api.cadastropessoa.repository.EnderecoRepository;
import com.api.cadastropessoa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<EnderecoModel> consultar() {
        return enderecoRepository.findAll().stream().map(EnderecoModel::new).toList();
    }

    @Override
    public EnderecoModel consultarPorId(Long id) {
        return new EnderecoModel(this.buscarId(id));
    }

    public List<EnderecoModel> consultarEndPrincipal(Boolean principal) {
        return enderecoRepository.findByEnderecoPrincipal(principal);
    }

    @Override
    public EnderecoModel cadastrar(EnderecoModel model) {
        var endereco = new Endereco(model);
        return new EnderecoModel(enderecoRepository.save(endereco));
    }

    @Override
    public EnderecoModel alterar(EnderecoModel model) {
        Endereco endereco = this.buscarId(model.getId()).editar(model);
        return new EnderecoModel(enderecoRepository.save(endereco));
    }

    @Override
    public void excluir(Long id) {
        enderecoRepository.deleteById(id);
    }

    private Endereco buscarId(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new RegistroNaoIdentificadoException(id));
    }
}
