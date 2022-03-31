package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log
public class TokenService {
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String PREFIX = "Bearer ";
    private static final String CHAVE_CARGOS = "CARGOS";

    @Value("${jwt.expiration}")
    private String expiration;
    @Value("${jwt.secret}")
    private String secret;

    public String getToken(Authentication authentication){//GERA UM TOKEN A PARTIR DO USUARIO E SENHA
        UsuarioEntity usuario = (UsuarioEntity) authentication.getPrincipal();

        Date now = new Date();//data atual
        Date exp = new Date(now.getTime()+Long.parseLong(expiration));//data de expiracao

        List<String> cargos = usuario.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String token = Jwts.builder()
                .setIssuer("pessoa-api")
                .setSubject(usuario.getIdUsuario().toString())
                .claim(CHAVE_CARGOS, cargos)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return PREFIX + token;
    }

    public Authentication getAuthentication(HttpServletRequest request){//VERIFICA AUTENTICACAO, RETORNANDO UM "UPAT" COM NOME DE USUARIO E PERMISSOES
        String tokenBearer = request.getHeader(HEADER_AUTHORIZATION);//busca o header com "Authorization"
        if(tokenBearer!=null){
            String token = tokenBearer.replaceFirst(PREFIX, "");//replace first pra nao correr risco? ou " " nao pode existir?
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            String user = body.getSubject();

            if(user!=null){
                List<String> grupos = (List<String>) body.get(CHAVE_CARGOS);
                List<SimpleGrantedAuthority> roles = grupos.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                return new UsernamePasswordAuthenticationToken(user, null, roles);
            }
        }
        return null;
    }
}
