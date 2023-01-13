/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.Connexion;
import BddObject.InfoDAO;
import BddObject.ObjectBDD;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dina
 */
@InfoDAO(table = "AppelEnchere")
public class AppelEnchere extends ObjectBDD {

    int id = -1;
    int produitUsersid=-1;
double prixMin=-1.0;
String dateDebut;
String dateExp;
    
    public int getId() {
        return id;
    }
    public ProduitUsers getProduitUsers() throws Exception {
        ProduitUsers vaovao = new ProduitUsers();
        vaovao.setId(this.produitUsersid);
        ArrayList<ProduitUsers> cpt = vaovao.select(null);
        return cpt.get(0);
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getProduitUsersid() {
        return produitUsersid;
    }

    public void setProduitUsersid(int produitUsersid) {
        this.produitUsersid = produitUsersid;
    }

    public double getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(double prixMin) {
        this.prixMin = prixMin;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

}
