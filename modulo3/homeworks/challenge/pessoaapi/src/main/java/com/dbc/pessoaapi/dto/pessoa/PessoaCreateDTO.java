package com.dbc.pessoaapi.dto.pessoa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @ApiModelProperty(value = "Nome da pessoa")
    @NotEmpty
    private String nome;
    @ApiModelProperty(value = "Data de nascimento da pessoa")
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @ApiModelProperty(value = "CPF da pessoa")
    @NotEmpty
    @Size(min=11, max=11)
    private String cpf;
    @ApiModelProperty(value = "Email da pessoa")
    @Email
    private String email;
}
