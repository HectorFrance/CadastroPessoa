package Cadastro.Pessoa.DTO;


import Cadastro.Pessoa.entity.Endereco;
import Cadastro.Pessoa.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private long id;
    private String nome;
    private String dataNascimento;
    private long IdEnderecoPricipal;
    List<EnderecoDTO> listaEnderecos;

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.IdEnderecoPricipal = pessoa.getIdEnderecoPricipal();

        List<Endereco> listaE = pessoa.getListaEnderecos();
        List<EnderecoDTO> listaEnderecoDTOS = new ArrayList<EnderecoDTO>();

        for(Endereco e: listaE){
            EnderecoDTO enderecoDTO = new EnderecoDTO(e);
            listaEnderecoDTOS.add(enderecoDTO);
        }

        this.listaEnderecos = listaEnderecoDTOS;
    }
}
