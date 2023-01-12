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
import static utils.UFunction.getMois;

/*
  @author dina
 */
@InfoDAO(table = "Salaire")
public class Salaire extends ObjectBDD {

    int id = -1;
    String daty;
    double montant=-1.0;

    public int getId() {
        return id;
    }
    public double getSalaireMensuel()throws Exception{
        ArrayList<Salaire>li=this.select(null);
    return li.get(0).getMontant();
    }
    public double getSalaireJour(int mois)throws Exception{
        return this.getSalaireMensuel()/UFunction.count_niasa(mois);
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDaty() {
        return daty;
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    

}
