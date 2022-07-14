package Cadastro.Pessoa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PESSOA", nullable = false, unique = true)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 200)
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private String dataNascimento;

   @Column(name = "ID_ENDERECO_PRINCIPAL")
   private long IdEnderecoPricipal;

   @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Endereco> listaEnderecos= new ArrayList<Endereco>();

}
