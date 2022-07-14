package Cadastro.Pessoa.service;

import Cadastro.Pessoa.entity.Pessoa;
import Cadastro.Pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listaPessoas(){
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPorId(long id){
        return pessoaRepository.findById(id);
    }

    public void removerPorId(long id){
        pessoaRepository.deleteById(id);
    }
}
