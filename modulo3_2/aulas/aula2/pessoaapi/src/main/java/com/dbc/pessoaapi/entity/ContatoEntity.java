package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.enums.TipoContato;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
//    @ManyToOne
//    @JoinColumn(name = "id_pessoa")
//    private PessoaEntity pessoaEntity;
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;
    @Column(name = "numero")
    private String numero;
    @Column(name = "descricao")
    private String descricao;

}
