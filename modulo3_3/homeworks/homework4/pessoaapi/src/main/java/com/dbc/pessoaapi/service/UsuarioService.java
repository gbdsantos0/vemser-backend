package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.login.LoginDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public void signUp(LoginDTO loginDTO) throws RegraDeNegocioException {

        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findByLogin(loginDTO.getLogin());
        if(usuarioExistente.isPresent()){
            throw new RegraDeNegocioException("Usuário já cadastrado no sistema");
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setLogin(loginDTO.getLogin());
        usuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));

        usuarioRepository.save(usuario);
    }

}
