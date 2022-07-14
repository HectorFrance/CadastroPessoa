package Cadastro.Pessoa.service;

import Cadastro.Pessoa.entity.Endereco;
import Cadastro.Pessoa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos(){ return enderecoRepository.findAll();}

    public Optional<Endereco> buscarPorId(long id){
        return enderecoRepository.findById(id);
    }

    public void removerPorId(long id){
        enderecoRepository.deleteById(id);
    }
}
