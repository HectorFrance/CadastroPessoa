package Cadastro.Pessoa.http.controller;

import Cadastro.Pessoa.entity.Pessoa;
import Cadastro.Pessoa.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return  pessoaService.salvar(pessoa);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listaPessoas(){
        return pessoaService.listaPessoas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa buscarPessoaPorId(@PathVariable("id") long id){
        return pessoaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPessoa(@PathVariable("id") long id){
        pessoaService.buscarPorId(id).map(pessoa-> {
            pessoaService.removerPorId(pessoa.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPessoa(@PathVariable("id") long id, @RequestBody Pessoa pessoa){

        pessoaService.buscarPorId(id).map(pessoaBase ->{
            modelMapper.map(pessoa,pessoaBase);
            pessoaService.salvar(pessoaBase);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada"));
    }
}
