package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        float salarioHora;
        int horasNormais;
        int horasExtras50;
        int horasExtras100;

        System.out.println("Informe seu salário/hora: ");
        salarioHora = sc.nextFloat();
        sc.nextLine();
        System.out.println("Informe as horas normais trabalhadas: ");
        horasNormais = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe as horas extras 50% trabalhadas: ");
        horasExtras50 = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe as horas extras 100% trabalhadas: ");
        horasExtras100 = sc.nextInt();
        sc.nextLine();

        System.out.println("Salário bruto: "+((horasNormais * salarioHora)+(horasExtras50 * salarioHora * 1.5)+(horasExtras100 * salarioHora * 2)));


    }
}
