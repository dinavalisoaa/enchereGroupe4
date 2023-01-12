/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static model.PointSource.PointSources;

/**
 *
 * @author dina
 */
public class Estimation {

    int freq;
    double montant;
    PointSource pts;

    public int getFreq() {
        return freq;
    }
    ///100g
    // Fitotona 15T
    // Volamena 10g

    public PointSource getPts() {
        return pts;
    }

    public void setPts(PointSource pts) {
        this.pts = pts;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public double getMontant() {
        return montant;
    }

    public double getBeneficeAvecDepense(int mois) throws Exception {
        return this.montant + getDepense(mois);
    }

    public double getOrTokonyProduit(int mois) throws Exception {
        System.out.println("->  Bene Avec Depense" + this.getBeneficeAvecDepense(mois) + " Vidina " + PrixVolamena.getMontantFarany() + "<- ");
        return this.getBeneficeAvecDepense(mois) / PrixVolamena.getMontantFarany();
    }

    public Estimation() {
    }

    public double getTokonyToto(int mois) throws Exception {
        double durete_pts = this.pts.getDureteJournalier(null);
        System.err.println("[[Durete en " + Integer.toString(freq) + " j =" + durete_pts + " t]]");
        double eff_pts = this.pts.getEfficaciteJournalier(null);
        System.err.println("[[Efficaite en " + Integer.toString(freq) + " j =" + eff_pts + " g]]");
        System.err.println("[[Or tokony produit" + this.getOrTokonyProduit(mois) + "g]]");

        double rap = durete_pts * this.getOrTokonyProduit(mois);
        double valiny = rap / eff_pts;
        return valiny-new Double(1.0);
//        return valiny ;

    }

    public double getTokonyTotoSelonVola(int mois) throws Exception {
        double durete_j = this.pts.getDureteJournalier(null);//ParFreq(Integer.toString(freq), null);
        System.err.println("[[Durete en  1 j =" + durete_j + " T ]]");
        double bene = this.pts.getBeneficeJournalier(mois, null);
        System.err.println("[[ Be" + bene + "Ar /j]]");
        double rap = durete_j * this.getBeneficeAvecDepense(mois);
        return rap / bene;
    }
    /// 15T /j---> 10 000 000/j
    //12 000 000          

    public double getDepense(int mois) throws Exception {
        double d = new PointSource().getDepense(mois, Integer.toString(this.freq), null);
        return d;
    }

//    public PointSo
    public Estimation(int freq, double mont) {
        this.freq = freq;
        this.montant = mont;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public /*PointSource[]*/ void getPossibilite(int mois) throws Exception {
//     double src.getBene("1", con)
        PointSource[] all_point = PointSource.PointSourcesNotNull();
        for (int i = 0; i < all_point.length; i++) {
            PointSource pointSource = all_point[i];
            double vola_vitany = pointSource.getBene(mois, String.valueOf(this.freq), null);
//         if(this.montant<=vola_vitany)
            {
                System.err.println("[" + vola_vitany + "]");
            }

//     22.880000000000003 t ---- 176h
//                                   1   
//0.13 t/h
//4.604166666 g/t 
//  PointSource src=new PointSource();
//        src.setId(15);
//     return null;
        }
    }
}
