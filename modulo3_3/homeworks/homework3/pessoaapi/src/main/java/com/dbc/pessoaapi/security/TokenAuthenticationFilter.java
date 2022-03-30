package com.dbc.pessoaapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {//roda o filtro de autenticacao
        Authentication authentication = tokenService.getAuthentication(request);//busca autenticacao
        SecurityContextHolder.getContext().setAuthentication(authentication);//todo seta autenticacao no context holder... quem?
        filterChain.doFilter(request, response);
    }

}
