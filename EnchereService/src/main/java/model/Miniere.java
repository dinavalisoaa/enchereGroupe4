/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAObject.Connexion;
import DAObject.InfoDAO;
import DAObject.ObjectBDD;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Miniere")
public class Miniere extends ObjectBDD {

    int id = -1;
    String nom;
    double largeur = -1.0;
    double longueur = -1.0;

    public int getId() {
        return id;
    }

    public PointSource[] getPointSources() throws Exception {
        PointSource p = new PointSource();

        p.setMiniereId(this.id);
        ArrayList<PointSource> hh = p.select(null);
        PointSource[] pts = new PointSource[hh.size()];
        for (int i = 0; i < hh.size(); i++) {
            PointSource get = hh.get(i);
            pts[i] = get;

        }
        return pts;
    }

//    public ArrayList getPointSourcesVaovao() throws Exception{
////       double[]sort=al
//    }
    public double[] getAllEfficacite(Connection con) throws Exception {
        Object[] all = this.getPointSources();
        double[] ret = new double[all.length];
        ArrayList<Double> lis = new ArrayList();
        for (int i = 0; i < all.length; i++) {
            PointSource get = (PointSource) all[i];
            lis.add(get.getEfficaciteJournalier(con));
//            lis.ore
        }
        for (int i = 0; i < lis.size(); i++) {
            Double get = lis.get(i);
            ret[i] = get;
        }
        Arrays.sort(ret);
        return ret;
    }

    public void trie(PointSource[]lp) throws Exception {
//        PointSource[] lp = this.getPointSources();
Connection con=Connexion.getConn();
        if (lp != null) {
            int i = 0;
            while (i < lp.length) {
                PointSource p = lp[i];
                int j = i;
                while (j > 0 && lp[j - 1].getEfficaciteJournalier(con) < p.getEfficaciteJournalier(con)) {
                    lp[j] = lp[j - 1];
                    j--;
                }
                lp[j] = p;
                i++;
            }
        }
         con.close();
    }
   
//
//    public  void triBulleCroissant(Object[] tableau) {
//        int longueur = tableau.length;
////                Object[]getPointSources()
//        int tampon = 0;
//        boolean permut;
//       PointSource[] lp = this.getPointSources();
//        do {
//            
//            // hypothèse : le tableau est trié
//            permut = false;
//            for (int i = 0; i < longueur - 1; i++) {
////                            double 
//                // Teste si 2 éléments successifs sont dans le bon ordre ou non
//                if (((PointSource) tableau[i]).getEfficaciteJournalier() > ((PointSource) tableau[i + 1]).getEfficaciteJournalier()) {
//                    // s'ils ne le sont pas, on échange leurs positions
//                    tampon = (PointSource) tableau[i]
//                    ).getEfficaciteJournalier()
//                    tableau[i] = tableau[i + 1];
//                    tableau[i + 1] = tampon;
//                    permut = true;
//                }
//            }
//        } while (permut);
//    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public static Miniere[] minieres() throws Exception {
        ArrayList lis = new Miniere().select(null);
        Miniere[] oo = new Miniere[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (Miniere) lis.get(i);
        }
        return oo;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
