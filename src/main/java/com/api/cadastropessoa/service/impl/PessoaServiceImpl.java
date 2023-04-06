package com.api.cadastropessoa.service.impl;

import com.api.cadastropessoa.entity.Pessoa;
import com.api.cadastropessoa.exception.RegistroNaoIdentificadoException;
import com.api.cadastropessoa.model.PessoaModel;
import com.api.cadastropessoa.repository.PessoaRepository;
import com.api.cadastropessoa.service.EnderecoService;
import com.api.cadastropessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public PessoaModel consultarPorId(Long id) {
        return new PessoaModel(this.buscarId(id));
    }

    @Override
    public List<PessoaModel> consultar() {
        return pessoaRepository.findAll().stream().map(PessoaModel::new).toList();
    }

    @Override
    public PessoaModel cadastrar(PessoaModel model) {
        var pessoa = new Pessoa(model);
        return new PessoaModel(pessoaRepository.save(pessoa));
    }
//    @Override
//    public PessoaModel cadastrar(PessoaModel model) {
//        EnderecoModel endereco = enderecoService.consultarPorId(model.getId());
//        var pessoa = new Pessoa(model,endereco);
//        return new PessoaModel(pessoaRepository.save(pessoa));
//    }


    @Override
    public PessoaModel alterar(PessoaModel model) {
        var pessoa = this.buscarId(model.getId()).editar(model);
        return new PessoaModel(pessoaRepository.save(pessoa));
    }

    @Override
    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }

    private Pessoa buscarId(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new RegistroNaoIdentificadoException(id));
    }
}
