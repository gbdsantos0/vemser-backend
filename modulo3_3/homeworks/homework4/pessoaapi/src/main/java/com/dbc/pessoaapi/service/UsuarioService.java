package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.login.LoginDTO;
import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.enums.GruposCargos;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final GrupoService grupoService;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public void signUp(LoginDTO loginDTO, List<GruposCargos> gruposCargos) throws Exception {

        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findByLogin(loginDTO.getLogin());
        if(usuarioExistente.isPresent()){
            throw new RegraDeNegocioException("Usuário já cadastrado no sistema");
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setLogin(loginDTO.getLogin());
        usuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));

        Set<GrupoEntity> grupoEntitySet = new HashSet<>();
        /*grupoEntitySet.addAll(
                gruposCargos.stream()
                        .map(gruposCargos1->{
                            GrupoEntity grupoEntity = null;
                            try {
                                grupoEntity = grupoService.getById(gruposCargos1.getIdCargo());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return grupoEntity;
                        })
                        .collect(Collectors.toList())
        );*/

        for(GruposCargos gruposCargos1: gruposCargos){
            GrupoEntity grupoEntity = grupoService.getById(gruposCargos1.getIdCargo());
            grupoEntitySet.add(grupoEntity);
        }

        usuario.setGrupos(grupoEntitySet);

        usuarioRepository.save(usuario);
    }

}
