package com.api.cadastropessoa;

import com.api.cadastropessoa.model.EnderecoModel;
import com.api.cadastropessoa.model.PessoaModel;
import com.api.cadastropessoa.service.EnderecoService;
import com.api.cadastropessoa.service.PessoaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class PessoaTest {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EnderecoService enderecoService;

    @Test
    @DisplayName("Cadastrar uma pessoa")
    void testCadastrar() {
        var endereco1 = EnderecoModel.builder()
                .logradouro("Centro")
                .cep("88798000")
                .numero(230)
                .cidade("Laguna")
                .principal(true)
                .build();

        var endereco2 = EnderecoModel.builder()
                .logradouro("Oficinas")
                .cep("88560000")
                .numero(10)
                .cidade("Tubarão")
                .principal(false)
                .build();

        final var pessoaModel = PessoaModel.builder()
                .nome("Ana")
                .dataNascimento(LocalDate.parse("1991-03-28"))
                .endereco(Arrays.asList(endereco1, endereco2))
                .build();

        var pessoa = pessoaService.cadastrar(pessoaModel);
        assertThat(pessoa).isNotNull();
        assertThat(pessoa.getNome()).isEqualTo("Ana");
        assertThat(pessoa.getDataNascimento()).isEqualTo("1991-03-28");
        assertThat(pessoa.getEndereco().size() > 0);
    }
    @Test
    @DisplayName("Busca todos")
    void testConsultar() {
        var pessoa = pessoaService.consultar();
        assertThat(pessoa.size() > 0);
    }
    @Test
    @DisplayName("Alterar")
    void testAlterar(){
        var id = 1L;
        var endereco1 = EnderecoModel.builder()
                .logradouro("Centro")
                .cep("88798000")
                .numero(230)
                .cidade("Laguna")
                .principal(true)
                .build();

        var endereco2 = EnderecoModel.builder()
                .logradouro("Oficinas")
                .cep("88560000")
                .numero(10)
                .cidade("Tubarão")
                .principal(false)
                .build();

        final var pessoaModel = PessoaModel.builder()
                .nome("Carolina")
                .dataNascimento(LocalDate.parse("1991-03-28"))
                .endereco(Arrays.asList(endereco1, endereco2))
                .build();

        var pessoa = pessoaService.alterar(pessoaModel);
        assertThat(pessoa).isNotNull();
        assertThat(pessoa.getNome()).isEqualTo("Carolina");
        assertThat(pessoa.getDataNascimento()).isEqualTo("1991-03-28");
        assertThat(pessoa.getEndereco().size() > 0);
    }
    @Test
    void testExcluir() {
        var pessoa = pessoaService.consultar();
        assertThat(pessoa).hasSize(1);
        pessoaService.excluir(1L);
        pessoa = pessoaService.consultar();
        assertThat(pessoa).hasSize(1);
    }

}


