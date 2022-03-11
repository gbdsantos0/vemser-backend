package com.dbc.aulamodulo3.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class PropertieReader {
    @Value("${ambiente}")
    private String valor;

    @GetMapping
    public String retorno(){
        System.out.println(valor);
        return valor;
    }
}
