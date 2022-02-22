package com.dbc.aula5.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> mapa = new HashMap<>();
        mapa.put("001","a");
        mapa.put("002","b");
        mapa.put("003","c");

        System.out.println(mapa);
        System.out.println(mapa.get("001"));
        System.out.println(mapa.remove("002"));
        System.out.println(mapa);
        System.out.println(mapa.keySet());
        System.out.println(mapa.values());
    }
}
