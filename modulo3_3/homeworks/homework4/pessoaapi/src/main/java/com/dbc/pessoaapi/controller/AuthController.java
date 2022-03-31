package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.login.LoginDTO;
import com.dbc.pessoaapi.dto.login.LoginExecutadoDTO;
import com.dbc.pessoaapi.enums.GruposCargos;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.security.TokenService;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {//retorna token de autorizacao a partir de usuario e senha
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getSenha());//gera UPAT de login

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);//autentica com o UPAT

        String token = tokenService.getToken(authenticate);//retorna o token a partir do Authentication

        return token;
    }

    @PostMapping("/sign-up")
    public LoginExecutadoDTO signUp(@RequestBody @Valid LoginDTO loginDTO, @RequestParam("lista_grupos_cargos")List<GruposCargos> gruposCargos) throws Exception{
        usuarioService.signUp(loginDTO, gruposCargos);
        LoginExecutadoDTO loginExecutadoDTO = new LoginExecutadoDTO();
        loginExecutadoDTO.setLogin(loginDTO.getLogin());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getSenha());//gera UPAT de login

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);//autentica com o UPAT

        String token = tokenService.getToken(authenticate);//retorna o token a partir do Authentication

        loginExecutadoDTO.setToken(token);

        return loginExecutadoDTO;
    }
}
