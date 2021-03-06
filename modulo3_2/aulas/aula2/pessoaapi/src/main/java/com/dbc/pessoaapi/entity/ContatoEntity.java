package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;
//    @Column(name = "id_pessoa")
//    private Integer idPessoa;
    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;
    @Column(name = "numero")
    private String numero;
    @Column(name = "descricao")
    private String descricao;

    @JsonIgnore
    //muitos contatos para uma pessoa....
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")//primeiro é da tabela contato, o segundo da pessoa
    private PessoaEntity pessoaEntity;

}
