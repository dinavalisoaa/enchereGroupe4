/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAObject.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.UFunction;
import static utils.UFunction.getJour;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Maintenance")
public class Maintenance extends ObjectBDD {

    int id = -1;
    double valeur = -1.0;
    String daty;
    @UnColumn
    double sum;
    @UnColumn
    int mois;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public double getValeurGasoil() throws Exception {
        ArrayList<Maintenance> gaz = new Maintenance().select(null);
        return gaz.get(0).getValeur();
    }
    public int getMoisInsertion() {
        Date daty = java.sql.Date.valueOf(this.daty);
        return daty.getMonth() + 1;
    }
    public Maintenance[] getGrandSomme(Connection con) throws Exception {
        ArrayList<Maintenance> list = this.selectAgregatBySQL(" select SUM(valeur)as sum ,extract(month from daty) as mois from maintenance group by extract(month from daty)", con);
        Maintenance[] main = new Maintenance[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Maintenance get = list.get(i);
            main[i] = get;
        }
        return main;
    }
    public double getMainteJour(int mois,Connection con)throws Exception{
        return this.getMainteMensuel(con)/UFunction.count_niasa(mois);
    }
    public double getMainteMensuel(Connection con) throws Exception{
        Maintenance[]fa=getGrandSomme(con);
        double sum=0.0;
        for (int i = 0; i < fa.length; i++) {
            Maintenance maintenance = fa[i];
            sum+=maintenance.getSum();
        }
        return sum/fa.length;
    }

    public static int[] getMoisRehetra(Connection con) throws Exception {
//       List li=new List();
        ArrayList s = new ArrayList();
        Maintenance[] oils = Maintenance.getMaintenances(con);
        for (int i = 0; i < oils.length; i++) {
            Maintenance oil = oils[i];
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

    public static int count_no_work(String date1, String date2) throws Exception {
        int d = utils.UFunction.dateDiff(date2, date1);
        java.util.Date inc = java.sql.Date.valueOf(date1);
        inc.setDate(inc.getDate() - 1);

        int cpt = 0;
        int g = 0;
        while (cpt < d) {
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

    public static boolean no_work(String date1) throws Exception {
        if (getJour(date1).equals("Tue") || getJour(date1).equals("Thu")) {
            return true;
        }
        return false;
    }

    public static HashMap<String, Double> getHASHMAP(Connection con) throws Exception {

        Maintenance[] oils = Maintenance.getMaintenances(con);

        HashMap<String, Double> ha = new HashMap<String, Double>();
        for (int i = 0; i < oils.length; i++) {
            if (i < oils.length - 1) {
                int cpt = 0;
                Maintenance oil = oils[i];
//                if (oil.getMoisInsertion() == 12)
                {
                    Maintenance oil2 = oils[i + 1];
                    int d = utils.UFunction.dateDiff(oil2.getDaty(), oil.getDaty());
                    java.util.Date inc = java.sql.Date.valueOf(oil.getDaty());
                    int nt =0;// count_no_work(oil.getDaty(), oil2.getDaty());
                    cpt = 0;
                    double diff = oil.getValeur() / (d - nt);
                    ha.put((oil2.getDaty()), diff);
                }
            } else {
                Maintenance oil = oils[oils.length - 2];
                {

                    Maintenance oil2 = oils[oils.length - 1];
                    int nt = count_no_work(oil.getDaty(), oil2.getDaty());
                    int d = utils.UFunction.dateDiff(oil2.getDaty(), oil.getDaty());
//                    if (no_work(oil2.getDaty()) == false)
                    {
                        double diff = oil2.getValeur();
                        ha.put((oil2.getDaty()), diff);

                    }

                }
            }

        }
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
    public String getLastOfMonth(String date){
        Date daty=java.sql.Date.valueOf(date);
        int mois=daty.getMonth();
        int mois_next=mois+1;
        while(daty.getMonth()<mois_next){
            daty.setDate(daty.getDate()+1);
        }
         daty.setDate(daty.getDate()-1);
         return daty.toString();
    }

    public static double[] getMoyenneParMois() throws Exception {
        Connection con = Connexion.getConn();
        int[] mois = Maintenance.getMoisRehetra(con);
        HashMap<String, Double> hasg = getHASHMAP(con);
        double[] moye = new double[mois.length];
        int cpt = 0;
        for (int i = 0; i < mois.length; i++) {
            double bv = 0;
            for (Map.Entry<String, Double> entry : hasg.entrySet()) {
                String key = entry.getKey();

                Double val = entry.getValue();
                if (utils.UFunction.getMois(key) == mois[i]) {
                    bv += val;
                    cpt++;
                }
            }
            double moyenne = bv / cpt;
            moye[i] = moyenne;
            System.out.println("MOYENNE"+cpt+" est:" + moyenne);
            cpt = 0;
        }
        con.close();
        return moye;
    }

    
     
//    public  Gasoil[] getMaintenances(Connection con) throws Exception {
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
    public static Maintenance[] getMaintenances(Connection con) throws Exception {
        Maintenance fits = new Maintenance();
//        fits.setPoi(this.id);
        ArrayList fitotona = fits.select(con);

        Maintenance[] retour = new Maintenance[fitotona.size()];
        for (int i = 0; i < fitotona.size(); i++) {
            Maintenance get = (Maintenance) fitotona.get(i);
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
