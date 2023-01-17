/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.Compte;
import java.sql.Connection;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import static java.util.stream.Collectors.joining;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import model.*;
import utils.UFunction;
import static utils.UFunction.count_niasa;
import static utils.UFunction.getJour;

/**
 *
 * @author dina
 */
public class MIa {

    public static Date[] mois_a_venir() {
        Date next = Date.valueOf("2022-12-12");
//        next.setDate(2);
        Date[] mois = new Date[12];
        for (int i = 0; i < mois.length; i++) {
            next.setMonth(next.getMonth() + 1);
            Date vao = new Date(next.getYear(), next.getMonth(), 1);
            mois[i] = vao;
        }
        return mois;
    }

    public static Date get_farany(Date next) {
        int mois = next.getMonth() + 1;
        int i = 0;
//        System.out.println("EEEE"+next.getMonth());
        while (i < 50) {
            next.setDate(next.getDate() + 1);
//           System.out.println(next.toString());
            if (mois == next.getMonth()) {
                break;
            }
            i++;
        }
//       next.setDate(next.getDate()-1);
        Date vao = new Date(next.getYear(), next.getMonth(), 1);
        vao.setDate(vao.getDate() - 1);
        return vao;
//       return
    }

    public static Date[] mois_a_venir_ext() {
        Date next = Date.valueOf("2022-12-12");
//        next.setDate(2);
        Date[] mois = new Date[12];
        for (int i = 0; i < mois.length; i++) {
            next.setMonth(next.getMonth() + 1);
            Date vao = new Date(next.getYear(), next.getMonth(), 1);
            mois[i] = get_farany(vao);
        }
        return mois;
    }

    public static int count_isTsyNiasa(String date1, String date2) throws Exception {
        int d = utils.UFunction.dateDiff(date2, date1);
        java.util.Date inc = java.sql.Date.valueOf(date1);
        inc.setDate(inc.getDate() - 1);

        int cpt = 0;
        int g = 0;
        while (cpt <= d) {
            inc.setDate(inc.getDate() + 1);
//            System.out.println("__" + inc.toString());
            if (getJour(inc.toString()).equals("Thu") || getJour(inc.toString()).equals("Tue")) {
                g++;
            }
            cpt++;
        }
//                System.out.println(date1 + "  <="+g+"=>  " + date2);

        return g;
    }

    public static int count_tsy_ouvrable(int si) throws Exception {
        Date[] fin = mois_a_venir_ext();
        Date[] deb = mois_a_venir();
        int re = 0;
        int d = 0;
        for (int i = 0; i < fin.length; i++) {
//            Date moi = mois[i];
            if (si == i + 1) {
                int nbr = utils.UFunction.dateDiff(fin[i].toString(), deb[i].toString());
                int tsy = count_isTsyNiasa(deb[i].toString(), fin[i].toString());
//                System.err.println(fin[i].toString());
//                System.err.println(tsy);
                re = nbr - tsy;
                d += re;

            }
        }
        return re;
    }

    public static void main(String[] args) throws Exception {
      // String  date is given
		String strDate = "2022-03-14T17:28:13.048999208";
		// parse the date into date time
	    LocalDateTime date = LocalDateTime.parse(strDate);
	    
		// Displaying date and time
		System.out.println("Date : "+date);
		
		// Add 2 hours to the date
		LocalDateTime newDate = date.plusHours(2);
		
		// Display result
		System.out.println("New Date : "+newDate);
    }

    /*
    8-9  0.4
        0.38
    
    
    
    
     */
}
