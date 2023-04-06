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
//    @Autowired
//    private PessoaRepository pessoaRepository;
//    @Autowired
//    private PessoaService pessoaService;

//    @Override
//    public EnderecoModel enderecoPrincipal(Long pessoaId) {
//        PessoaModel pessoa = pessoaService.consultarPorId(pessoaId);
//        List<Endereco> enderecos = pessoa.getEndereco();
////        EnderecoModel endereco = enderecos.stream().filter(end -> Objects.equals(end.meuEndereco(),true)).findFirst()
//        return null;
//    }

    @Override
    public List<EnderecoModel> consultar() {
        return enderecoRepository.findAll().stream().map(EnderecoModel::new).toList();
    }

    @Override
    public EnderecoModel consultarPorId(Long id) {
        return new EnderecoModel(this.buscarId(id));
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
