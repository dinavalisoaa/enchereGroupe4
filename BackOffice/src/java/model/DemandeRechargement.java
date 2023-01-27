/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@InfoDAO(table = "DemandeRechargement")
public class DemandeRechargement extends ObjectBDD {

    int id = -1;//             SERIAL NOT NULL, 
    String dateDemande;//    date DEFAULT current_date, 
    int state = -1;//          int4, 
    int usersId = -1;//        int4 NOT NULL, 
    double montant = -1;//        float8, 
    String dateValidation;

    public Users getUsers() throws Exception {
        Users us = new Users();
        us.setId(this.usersId);
        return ((Users) us.select(null).get(0));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) throws Exception {
//        if (montant < this.getUsers().getCurrentMoney()) {
//            throw new Exception("Solde inferieur");
//        } else {
            this.montant = montant;
//        }
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(String dateValidation) {
        this.dateValidation = dateValidation;
    }

}
