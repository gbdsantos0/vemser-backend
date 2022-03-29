package com.dbc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Colas {
    public static void main(String[] args) throws Exception {
        Date minhaData = new Date();
        System.out.println(minhaData);
        System.out.println(minhaData.getTime());

        Date minhaDataZero = new Date();
        minhaDataZero.setTime(0);
        System.out.println(minhaDataZero);

        Date minhaData2 = new Date(2022-1900, 0, 1);
        System.out.println(minhaData2);

        System.out.println(minhaData.before(minhaData2));
        System.out.println(minhaData.after(minhaData2));

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");



        System.out.println(formato.format(minhaData2));

        //AULA1
        //EXERCICIO1

        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");

        Date data = new Date(1995-1900,12-1,30, 10, 15);
        System.out.println(formato2.format(data));

        Scanner sc = new Scanner(System.in);
        System.out.println("digite a data");
        String dataDigitada = "01/01/1991";//sc.nextLine();



        data = formato2.parse(dataDigitada);//parse da string de acordo com o formato do SimpleDateFormat
        System.out.println(formato2.format(data));

        //PARTE2 AULA
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        data = calendar.getTime();
        System.out.println(data);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.set(Calendar.YEAR, 1);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        System.out.println(calendar.getTime());

        Calendar calendarComTimeZone = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
        System.out.println(calendarComTimeZone.getTime());

        DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println(dateFormat.format(calendar.getTime()));

        Locale brasil = new Locale("pt", "BR");
        Locale eua = Locale.US;

        DateFormat format2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println(format2.format(calendar.getTime()));

        //PARTE3 AULA
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(LocalDate.of(2024,2,29));
        System.out.println(LocalDate.parse("2015-02-15"));

        System.out.println(now.plusDays(10));

        DayOfWeek diaDaSemana = now.getDayOfWeek();
        System.out.println(diaDaSemana);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(LocalTime.parse("06:30"));
        System.out.println(LocalTime.of(10,15));

        System.out.println(localTime.plusHours(5).isAfter(LocalTime.now()));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(LocalDateTime.of(2015,1,15,6,15));
        System.out.println(LocalDateTime.parse("2015-02-20T06:30:15"));

        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(5)));
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now().plusYears(4)));

        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDateTime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")));
        System.out.println(localDateTime2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt-BR"))));


    }

}
