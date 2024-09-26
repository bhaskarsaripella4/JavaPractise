package com.protean.flakey;

import java.time.*;
import java.time.format.*;

public class myclass{

    public static void main(String[] args){

//        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
//
//        String dateInString = "07/06/2013 10:11:59";
//        DateTime dateTime = DateTime.parse(dateInString, formatter);
//        DateTime dateTimeWithZone = dateTime.withZone(DateTimeZone.forID("Asia/Kolkata"));
        LocalDate localDate = LocalDate.of(2015,4,4);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MM/dd/Yy")));
    }

}
