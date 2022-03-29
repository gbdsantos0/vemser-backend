package com.dbc;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args){

        //HOMEWORK
        //todo 1 - tempo que falta pro proximo aniversario(scan da data)
        System.out.println("#########################################################################################################################################################");
        System.out.println("Exercicio 1");
//        LocalDate aniversario = new SimpleDateFormat("dd/MM/yyyy").parse(new Scanner(System.in).nextLine()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Insira sua data de aniversário");
        LocalDate aniversario = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataAtual = LocalDate.now();
        if(aniversario.isBefore(dataAtual)){
            Period periodoFaltante = Period.between(dataAtual, aniversario.withYear(dataAtual.getYear()).isAfter(dataAtual)?aniversario.withYear(dataAtual.getYear()):aniversario.withYear(dataAtual.getYear()+1));
            System.out.println(periodoFaltante.getMonths()+" meses e "+periodoFaltante.getDays()+" dias");
        }else{
            System.out.println("Você nem nasceu ainda");
        }

        //todo 2 - duas datas e diferença em dias/meses/anos
        System.out.println("\n#########################################################################################################################################################");
        System.out.println("Exercicio 2");
        System.out.println("escreva duas datas para comparar");
        LocalDate data1 = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate data2 = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period periodoDuasDatas = Period.between(data1, data2);
        System.out.println("Diferença das datas\nDias: "+periodoDuasDatas.getDays()+"\nMeses: "+ periodoDuasDatas.getMonths()+"\nAnos: "+ periodoDuasDatas.getYears());
        //todo 3 - horario atual brasil, austrália, japao, russia, dubai, eua
        System.out.println("\n#########################################################################################################################################################");
        System.out.println("Exercicio 3");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss - dd/MM/yyyy");
        System.out.println("Hora atual Brasil:\t\t" + LocalDateTime.now(ZoneId.of("UTC-03:00")).format(format));
        System.out.println("Hora atual Australia:\t" + LocalDateTime.now(ZoneId.of("UTC+10:00")).format(format));
        System.out.println("Hora atual Japão:\t\t" + LocalDateTime.now(ZoneId.of("UTC+09:00")).format(format));
        System.out.println("Hora atual Russia:\t\t" + LocalDateTime.now(ZoneId.of("UTC+03:00")).format(format));
        System.out.println("Hora atual Dubai:\t\t" + LocalDateTime.now(ZoneId.of("UTC+04:00")).format(format));
        System.out.println("Hora atual EUA:\t\t\t" + LocalDateTime.now(ZoneId.of("UTC-07:00")).format(format));

        //todo 4 - dia da semana e do ano do dia atual+15 dias e 10h
        System.out.println("\n#########################################################################################################################################################");
        System.out.println("Exercicio 4");
        LocalDateTime horaAtualEx4 = LocalDateTime.now();
        LocalDateTime horaQuinzeDias = horaAtualEx4.plusDays(15).plusHours(10);
        Period periodoAteQuinzeMais = Period.between(horaAtualEx4.toLocalDate(), horaQuinzeDias.toLocalDate());
        System.out.println("Informações daqui 15 dias e 10 horas"
                +"\nDia da semana:\t\t"+horaQuinzeDias.getDayOfWeek()
                +"\nDia:\t\t\t\t"+horaQuinzeDias.format(format));
        //todo 5 - instanciar data, imprimir brasileira, eua e francesa
        System.out.println("\n#########################################################################################################################################################");
        System.out.println("Exercicio 5");
        LocalDateTime horaInstanciada = LocalDateTime.of(2022,3,28,18,41,49);
        DateTimeFormatter formatBrasil = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt-BR"));
        DateTimeFormatter formatUSA = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US);
        DateTimeFormatter formatFranca = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.FRANCE);
        System.out.println("Data Brasil:\t\t" + horaInstanciada.format(formatBrasil));
        System.out.println("Data USA:\t\t\t" + horaInstanciada.format(formatUSA));
        System.out.println("Data França:\t\t" + horaInstanciada.format(formatFranca));
        //todo 6 -  14/09/2024 18h30 londres, anos, meses, dias, horas, minutos e segundos para o evento no nosso padrao
        System.out.println("\n#########################################################################################################################################################");
        System.out.println("Exercicio 6");
        LocalDateTime horaAtualEx6 = LocalDateTime.now().atZone(ZoneId.of("UTC-03:00")).toLocalDateTime();
        LocalDateTime horaWesleySabbath = LocalDateTime.of(2024,9,14,18,30).atZone(ZoneId.of("UTC+01:00")).withZoneSameInstant(ZoneId.of("UTC-03:00")).toLocalDateTime();
        System.out.println("Hora atual BRT:\t\t\t"+horaAtualEx6);
        System.out.println("Hora do show em BRT:\t"+horaWesleySabbath);


        LocalDateTime horaTemporariaEx6 = LocalDateTime.from(horaAtualEx6);

        long anos = horaTemporariaEx6.until(horaWesleySabbath, ChronoUnit.YEARS);
        horaTemporariaEx6 = horaTemporariaEx6.plusYears(anos);
        long meses = horaTemporariaEx6.until(horaWesleySabbath, ChronoUnit.MONTHS);
        horaTemporariaEx6 = horaTemporariaEx6.plusMonths(meses);
        long dias = horaTemporariaEx6.until(horaWesleySabbath, ChronoUnit.DAYS);
        horaTemporariaEx6 = horaTemporariaEx6.plusDays(dias);
        long horas = horaTemporariaEx6.until(horaWesleySabbath, ChronoUnit.HOURS);
        horaTemporariaEx6 = horaTemporariaEx6.plusHours(horas);
        long minutos = horaTemporariaEx6.until(horaWesleySabbath, ChronoUnit.MINUTES);
        horaTemporariaEx6 = horaTemporariaEx6.plusMinutes(minutos);
        long segundos = horaTemporariaEx6.until(horaWesleySabbath, ChronoUnit.SECONDS);
        horaTemporariaEx6 = horaTemporariaEx6.plusSeconds(segundos);

        System.out.println("Tempo restante até o grande show de Wesley Safadão e Black Sabbath");
        System.out.println("Anos:\t\t"+anos);
        System.out.println("Meses:\t\t"+meses);
        System.out.println("Dias:\t\t"+dias);
        System.out.println("Horas:\t\t"+horas);
        System.out.println("Minutos:\t"+minutos);
        System.out.println("Segundos:\t"+segundos);
    }
}
