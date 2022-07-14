package Cadastro.Pessoa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Endereco  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ENDERECO", nullable = false, unique = true)
    private Long id;

    @Column(name = "LOGRADOURO", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "CEP", nullable = false,length = 10)
    private String cep;
    @Column(name = "NUMERO", nullable = false,length = 4)
    private String numero;

    @Column(name = "CIDADE", nullable = false,length = 20)
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "PESSOA")
    private Pessoa pessoa;
}
