package Cadastro.Pessoa.http.controller;

import Cadastro.Pessoa.DTO.EnderecoDTO;
import Cadastro.Pessoa.entity.Endereco;
import Cadastro.Pessoa.service.EnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@RequestBody Endereco endereco) {return enderecoService.salvar(endereco);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnderecoDTO> listaEnderecos(){
        List<Endereco> listaE =  enderecoService.listarEnderecos();
        List<EnderecoDTO> listaEnderecoDTOS = new ArrayList<EnderecoDTO>();
        for(Endereco e: listaE){
            EnderecoDTO enderecoDTO = new EnderecoDTO(e);
            listaEnderecoDTOS.add(enderecoDTO);
        }
        return listaEnderecoDTOS;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  EnderecoDTO buscarEnderecoPorId(@PathVariable("id") long id){
        EnderecoDTO enderecoDTO = new EnderecoDTO(enderecoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado")));
        return enderecoDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEndereco(@PathVariable("id") long id){
        enderecoService.buscarPorId(id).map(endereco -> {
            enderecoService.removerPorId(endereco.getId());
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEndereco(@PathVariable long id, @RequestBody Endereco endereco){

        enderecoService.buscarPorId(id).map(enderecoBase ->{
            modelMapper.map(endereco,enderecoBase);
            enderecoService.salvar(enderecoBase);
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Endereco não Encontrado"));
    }
}
