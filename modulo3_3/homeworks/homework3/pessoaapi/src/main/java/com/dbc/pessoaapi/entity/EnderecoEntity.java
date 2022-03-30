package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;
//    @Column(name = "id_pessoa")
//    private Integer idPessoa;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "pais")
    private String pais;
    @Column(name = "tipo")
    private TipoEndereco tipo;
    @Column(name = "cep")
    private String cep;
    @Column(name = "complemento")
    private String complemento;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Pessoa_X_Pessoa_Endereco"
            ,joinColumns = @JoinColumn(name = "id_endereco")
            ,inverseJoinColumns = @JoinColumn(name = "id_pessoa")
    )
    private Set<PessoaEntity> pessoas;
}
