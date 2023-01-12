/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.util.ArrayList;

/**
 *
 * @author dina
 */
@InfoDAO(table = "PrixVolamena")
public class PrixVolamena extends ObjectBDD {

    int id = -1;
    double montant = -1.0;
    String daty;

    public String getDaty() {
        return daty;
    }
    public static double getMontantFarany() throws Exception{
        ArrayList<PrixVolamena> prix=new PrixVolamena().executeSQL("select *from prixvolamena where daty<=CURRENT_DATE limit 1", null);
    return prix.get(0).getMontant();
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
