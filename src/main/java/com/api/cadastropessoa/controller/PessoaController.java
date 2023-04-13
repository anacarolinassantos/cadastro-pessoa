package com.api.cadastropessoa.controller;

import com.api.cadastropessoa.model.PessoaModel;
import com.api.cadastropessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @GetMapping("/consultar")
    public List<PessoaModel> consultar() {
        return pessoaService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public PessoaModel consultarPorId(@PathVariable Long id) {
        return pessoaService.consultarPorId(id);
    }

    @PostMapping("/cadastrar")
    public PessoaModel cadastrar(@RequestBody PessoaModel model) {
        return pessoaService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public PessoaModel alterar(@RequestBody PessoaModel model) {
        return pessoaService.alterar(model);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable Long id) {
        pessoaService.excluir(id);
    }
}
