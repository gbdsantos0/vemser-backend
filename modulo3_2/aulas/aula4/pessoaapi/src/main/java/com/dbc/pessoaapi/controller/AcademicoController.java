package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.pessoa.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.enums.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.EnderecoService;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/ciencia")
public class AcademicoController {
    //PARA FINS ACADEMICOS
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ContatoService contatoService;


    //AULA2
    //EXERCICIO 2
    @ApiOperation(value = "Retorna uma lista de pessoas por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-nome")
    public List<PessoaDTO> listByName(@RequestParam(value = "nome") String nome) throws Exception{
        return pessoaService.listByName(nome);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas por cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-cpf")
    public List<PessoaDTO> listByCpf(@RequestParam(value = "cpf") String cpf) throws Exception{
        return pessoaService.listByCpf(cpf);
    }

    //AULA 3
    //EXERCICIO 1
    @GetMapping("/listar-por-data-periodo-2")
    public List<PessoaEntity> listByDatePeriod2(@RequestParam(value = "data_inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento1,
                                                @RequestParam(value = "data_final") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento2) throws Exception{
        return pessoaRepository.findByDateBetween2(dataNascimento1, dataNascimento2);
    }

    @GetMapping("/listar-por-possui-endereco")
    public List<PessoaEntity> listByHasAddress() throws Exception{
        return pessoaRepository.findByHasAddress();
    }

    @GetMapping("/listar-por-tipo-contato")
    public List<ContatoEntity> listByTipoContato(@RequestParam(value = "tipo") TipoContato tipo) throws Exception{
        return contatoRepository.findByTipoContato(tipo);
    }

    @GetMapping("/endereco-por-pais")
    public List<EnderecoEntity> findByPais(@RequestParam(value = "pais") String pais) throws Exception{
        return enderecoRepository.findAddressByState(pais);
    }

    @GetMapping("/endereco-por-id-pessoa")
    public List<EnderecoEntity> findByidPessoa(@RequestParam(value = "idPessoa") Integer idPessoa) throws Exception{
        return enderecoRepository.findAddressByIdPessoa(idPessoa);
    }

    //EXERCICIO2
    @GetMapping("/enderecos-por-cidade-ou-pais")
    public List<EnderecoEntity> findByCidadeOuPais(@RequestParam(value = "cidade", required = false) String cidade, @RequestParam(value = "pais", required = false) String pais) throws Exception{
        if(cidade==null&&pais==null){
            throw new RegraDeNegocioException("informe pelo menos um dado");
        }
        return enderecoRepository.findByCidadeOrPais(cidade, pais);
    }
    @GetMapping("/enderecos-sem-complemento")
    public List<EnderecoEntity> findEnderecoSemComplemento() throws Exception{

        return enderecoRepository.findComplementoNull();
    }
    @GetMapping("/contatos-por-id-pessoa")
    public List<ContatoEntity> findContatoByIdPessoa(@RequestParam(value = "idPessoa") Integer idPessoa) throws Exception{
        return contatoRepository.findByIdPessoa(idPessoa);
    }
    @GetMapping("/pessoas-sem-endereco")
    public List<PessoaEntity> findPessoaSemEndereco() throws Exception{
        return pessoaRepository.findPessoaSemEndereco();
    }

    //AULA4
    /*@GetMapping("/by-paginacao")
    public Page<PessoaEntity> findByNamePaged(@RequestParam(value = "paginaSolicitada") Integer paginaSolicitada, @RequestParam(value = "tamanhoDaPagina") Integer tamanhoDaPagina, @RequestParam(value = "") String nome){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("cpf").descending().and(Sort.by("nome")));
        return pessoaRepository.findByNomeContainsIgnoreCase(nome.toUpperCase(Locale.ROOT), pageable);
    }*/
}
