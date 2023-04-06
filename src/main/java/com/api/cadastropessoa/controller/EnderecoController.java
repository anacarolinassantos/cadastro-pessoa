package com.api.cadastropessoa.controller;

import com.api.cadastropessoa.model.EnderecoModel;
import com.api.cadastropessoa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/consultar")
    public List<EnderecoModel> consultar() {
        return enderecoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public EnderecoModel consultarPorId(@PathVariable Long id) {
        return enderecoService.consultarPorId(id);
    }

    @PostMapping("/cadastrar")
    public EnderecoModel cadastrar(@RequestBody EnderecoModel model) {
        return enderecoService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public EnderecoModel alterar(@RequestBody EnderecoModel model) {
        return enderecoService.alterar(model);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable Long id) {
        enderecoService.excluir(id);
    }
}