/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static utils.UFunction.getJour;
import static utils.UFunction.getMois;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Gasoil")
public class Gasoil extends ObjectBDD {

    int id = -1;
    double valeur = -1.0;
    String daty;

    public double getValeurGasoil() throws Exception {
        ArrayList<Gasoil> gaz = new Gasoil().select(null);
        return gaz.get(0).getValeur();
    }

    public int getMoisInsertion() {
        Date daty = java.sql.Date.valueOf(this.daty);
        return daty.getMonth() + 1;
    }

    public static int[] getMoisRehetra(Connection con) throws Exception {
//       List li=new List();
        ArrayList s = new ArrayList();
        Gasoil[] oils = Gasoil.getGasoils(con);
        for (int i = 0; i < oils.length; i++) {
            Gasoil oil = oils[i];
//              System.out.println("model.Gasoil.getMoisRehetra()"+oil.getMoisInsertion());
            s.add(oil.getMoisInsertion());
        }
        List<Integer> l = s;
        Object[] va=l  .stream().distinct().toArray();
        int taille = va.length;
        int[] vao = new int[taille];
        for (int i = 0; i < taille; i++) {
            int oil = (int) va[i];
            vao[i] = oil;
        }
        return vao;
    }
//
//    public double getMoyenneMois(int mois, Connection c) throws Exception {
//        int n = 0;
//        double somme = 0;
//        int ind = 0;
//        Date[] allDate = this.allRehetre(c);
//        ArrayList<Gasoil> liste = new Gasoil().select(c);
//        for (int i = 0; i < allDate.length; i++) {
//            System.out.println(allDate[i].toString());
//
//            if ((allDate[i].getMonth() + 1) == mois) {
//                n++;
////                System.out.println("" + allDate[i].getMonth() + 1);
////
//                ind = this.getIndiceDateAchat(allDate[i].toString(), c);
////                System.out.println(liste.get(ind).getMontant() + "/" + this.getJourConsommation(ind, c));
//                somme = somme + ((double) (liste.get(ind).getValeur() / this.getJourConsommation(ind, c)));  //ex: 200000 / 4
//                System.out.println(somme);
//            }
//        }
//        somme = somme + liste.get(liste.size() - 1).getValeur();
//        System.out.println("Itooo ilay sommeee: " + somme);
//        n = n + 1;
//        System.out.println("Itooo ilay nombre de jour: " + n);
//        ////
//        double moyenne = (double) somme / n;
//        return moyenne;
//    }
//
//    public int getJourConsommation(int i, Connection c) throws Exception {
//        ArrayList<Gasoil> liste = new Gasoil().select(c);
//        int nb = 0;
//        if (i != liste.size() - 1) {
//            Date d1 = Date.valueOf(liste.get(i).getDaty());
//            while (d1.before(Date.valueOf(liste.get(i + 1).getDaty()))) {
//                if ((!(getJour(d1.toString()).equals("Thu"))) || (!getJour(d1.toString()).equals("Tue"))) {
//                    nb++;
//
//                }
//                d1.setDate(d1.getDate() + 1);
//            }
//
//        }
//        return nb;
//    }


    public static boolean isWork(String date1) throws Exception {
//            System.out.println("__" + inc.toString());
        if (getJour(date1.toString()).equals("Thu") || getJour(date1.toString()).equals("Tue")) {
            return true;
        }
//                System.out.println(date1 + "  <="+g+"=>  " + date2);

        return false;
    }

    public static int count_isTsyNiasa(String date1, String date2) throws Exception {
        int d = utils.UFunction.dateDiff(date2, date1);
        java.util.Date inc = java.sql.Date.valueOf(date1);
        inc.setDate(inc.getDate() - 1);
        int cpt = 0;
        int g = 0;
        while (cpt < d) {
            inc.setDate(inc.getDate() + 1);
           
            if (getJour(inc.toString()).equals("Thu") || getJour(inc.toString()).equals("Tue")) {
                g++; 
            }
//                        System.out.println("__"+getJour(inc.toString())+"__" + inc.toString());

            cpt++;
        }
//                System.out.print ln(date1 + "  <="+g+"=>  " + date2);

        return g;
    }

    public static boolean isTsyNiasa(String date1) throws Exception {
        if (getJour(date1).equals("Tue") || getJour(date1).equals("Thu")) {
            return true;
        }
        return false;
    }
/// 12g <---- Vato 25T
//sommm/vidiny 50g ?

    public Date[] allRehetre(Connection c) throws Exception {
        ArrayList<Gasoil> liste = new Gasoil().select(c);
        ArrayList<Date> allDate = new ArrayList<Date>();
        Date d1 = Date.valueOf(liste.get(0).getDaty());
//        d1.setDate(d1.getDate() - 1);
        Date d2 = Date.valueOf(liste.get(liste.size() - 1).getDaty());
        while (d1.before(d2)) {
            if ((!(getJour(d1.toString()) == "Tue")) && (!(getJour(d1.toString()) == "Thu"))) {
                Date d = new Date(d1.getYear(), d1.getMonth(), d1.getDate());
                allDate.add(d);
            }
//           name="input"
//            =GET['list']
            d1.setDate(d1.getDate() + 1);
        }

        Date[] tab = new Date[allDate.size()];
        for (int i = 0; i < allDate.size(); i++) {
            tab[i] = allDate.get(i);
        }
        return tab;
    }

    public static HashMap<String, Double> getHASHMAP(Connection con) throws Exception {

        Gasoil[] oils = Gasoil.getGasoils(con);
//        System.out.println("TAILLE" + oils.length);
        double ks = 0;
        HashMap<String, Double> ha = new HashMap<String, Double>();
        ArrayList<String> key = new ArrayList<String>();
        ArrayList<Double> value = new ArrayList<Double>();

        for (int i = 0; i < oils.length; i++) {
            if (i < oils.length - 1) {
                int cpt = 0;
                Gasoil oil = oils[i];
//                if (oil.getMoisInsertion() == 12)
                {
//                e
                    Gasoil oil2 = oils[i + 1];
                    int d = utils.UFunction.dateDiff(oil2.getDaty(), oil.getDaty());
                    java.util.Date inc = java.sql.Date.valueOf(oil.getDaty());
                    Date en_cours = Date.valueOf(oil.getDaty());
                    Date next = Date.valueOf(oil2.getDaty());
                    int nt = count_isTsyNiasa(oil.getDaty(), oil2.getDaty());
//                    int nt =0;// count_isTsyNiasa(oil.getDaty(), oil2.getDaty());
                    cpt = 0;
                    double diff = oil.getValeur(/**/) / (d - nt);
                    ks += diff;
//                    System.err.println("__" + oil.getDaty() + " difference :" + diff + " NTW" + nt);
                    while (en_cours.before(next)) {
                        if (isTsyNiasa(en_cours.toString()) == false)
                        {
                            ha.put(en_cours.toString(), diff);
                        }
                            en_cours.setDate(en_cours.getDate() + 1);
                    }
                }
            } 
//          //  @Dans le cas le dernier est supposer tout consommer
//            else {
//                Gasoil oil = oils[oils.length - 2];
//                    Gasoil oil2 = oils[oils.length - 1];
//                    int nt = count_isTsyNiasa(oil.getDaty(), oil2.getDaty());
//                    int d = utils.UFunction.dateDiff(oil2.getDaty(), oil.getDaty());
//                    if (isTsyNiasa(oil2.getDaty()) == false)
//                    {
//                        double diff = oil2.getValeur();
//                        ha.put((oil2.getDaty()), diff);
//                        ks += diff;
//                    }
//
//            }

        }
//        for (int i = 0; i < value.size(); i++) {
//            Double vals = value.get(i);
//            String keys = key.get(i);
//            System.out.println("vals" + vals + "   keys" + keys);
//
//        }
        return ha;
    }

    public static boolean isEntre(String date1, String date2, String taken) {
        java.util.Date daty1 = java.sql.Date.valueOf(date1);
        java.util.Date daty2 = java.sql.Date.valueOf(date2);
        java.util.Date takens = java.sql.Date.valueOf(taken);

        if (takens.after(daty1) && takens.before(daty2)) {
            return true;
        }
        return false;
    }

    public static double getGasoilParJour(Connection con) throws Exception {
        double[] var = getMoyenne(con);
        double re = 0;
        for (int i = 0; i < var.length-1; i++) {
            re += var[i];
            System.out.println("model.Gasoil.getMoyenne()" + var[i]);

        }
        return re / var.length;
    }

    public static double[] getMoyenne(Connection con) throws Exception {
        int[] mois = Gasoil.getMoisRehetra(con);
        HashMap<String, Double> hasg = getHASHMAP(con);
//        System.out.println("[[==" + hasg);
        double[] moye = new double[mois.length];
        int cpt = 0;
        for (int i = 0; i < mois.length; i++)
        {
            double bv = 0;
            for (Map.Entry<String, Double> entry : hasg.entrySet()) {
                String key = entry.getKey();
                Double val = entry.getValue();
                if (getMois(key) == mois[i]) {
                    bv += val;
                    cpt++;
                   
                }
            }
            
            //// GASOIL+MAINTE+SALAIRE
//             System.out.println("_++_+_+"+cpt);
            double moyenne = bv / cpt;
            moye[i] = moyenne;
            System.out.println("MOYENNE" + cpt + " est:" + moyenne);
            cpt = 0;
        }
        return moye;
    }

//    public  Gasoil[] getGasoils(Connection con) throws Exception {
//        Gasoil fits = new Gasoil();
////        fits.setPoi(this.id);
//        ArrayList fitotona = this.select(con);
//        Gasoil[] retour = new Gasoil[fitotona.size()];
//        for (int i = 0; i < fitotona.size(); i++) {
//            Gasoil get = (Gasoil) fitotona.get(i);
//            retour[i] = get;
//        }
//        return retour;
//    }
    public static Gasoil[] getGasoils(Connection con) throws Exception {
        Gasoil fits = new Gasoil();
//        fits.setPoi(this.id);
        ArrayList fitotona = fits.select(con);

        Gasoil[] retour = new Gasoil[fitotona.size()];
        for (int i = 0; i < fitotona.size(); i++) {
            Gasoil get = (Gasoil) fitotona.get(i);
            retour[i] = get;
        }
        return retour;
//        return fitotona.toArray();
    }

    public int getId() {
        return id;
    }

    public String getDaty() {
        return daty;
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

}
