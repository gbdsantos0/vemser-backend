package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.EnderecoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/paginacao")
public class PaginacaoController {
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

    //AULA4
    @GetMapping("/contato-ordenado-pela-descricao")
    public Page<ContatoEntity> findContatoOrdDescr(@RequestParam(value = "paginaSolicitada") Integer paginaSolicitada,
                                                   @RequestParam(value = "tamanhoDaPagina") Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("descricao"));
        return contatoRepository.findAll(pageable);
    }
    @GetMapping("/endereco-ordenado-pelo-cep")
    public Page<EnderecoEntity> findEnderecoOrdCep(@RequestParam(value = "paginaSolicitada") Integer paginaSolicitada,
                                                   @RequestParam(value = "tamanhoDaPagina") Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("cep"));
        return enderecoRepository.findAll(pageable);
    }
    @GetMapping("/endereco-filtrada-por-pais")
    public Page<EnderecoEntity> findEnderecoOrdPais(@RequestParam(value = "paginaSolicitada") Integer paginaSolicitada,
                                                    @RequestParam(value = "tamanhoDaPagina") Integer tamanhoDaPagina,
                                                    @RequestParam(value = "pais") String pais){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina);
        return enderecoRepository.findByPaisIgnoreCase(pais, pageable);
    }
}
