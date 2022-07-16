package Cadastro.Pessoa.DTO;


import Cadastro.Pessoa.entity.Endereco;
import Cadastro.Pessoa.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    List<Endereco> listaEnderecos;

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.IdEnderecoPricipal = pessoa.getIdEnderecoPricipal();
        this.listaEnderecos = pessoa.getListaEnderecos();
    }
}
