package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log
public class TokenService {
    private static final String CARACTER_REPARACAO = ";";
    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity){//GERA UM TOKEN A PARTIR DO USUARIO E SENHA
        String tokenTexto = usuarioEntity.getLogin() + CARACTER_REPARACAO + usuarioEntity.getSenha();
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes());
        log.info("token gerado: "+token);
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token){//DECODIFICA O TOKEN EM USUARIO E SENHA DE ALGUMA FORMA MATEMAGICA PARA BUSCAR NO DB
        if(token == null){
            return Optional.empty();
        }
        byte[] decodedTokenBytes = Base64.getUrlDecoder().decode(token);
        String decodedTokenString = new String(decodedTokenBytes);
        String[] usuarioESenha = decodedTokenString.split(CARACTER_REPARACAO);
        return usuarioService.findByLoginAndSenha(usuarioESenha[0], usuarioESenha[1]);
    }
}
