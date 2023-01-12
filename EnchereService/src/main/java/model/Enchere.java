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
@InfoDAO(table = "Enchere")
public class Enchere extends ObjectBDD {

    int id = -1;
    String dateMise;
    double prixMise=-1.0;
    int usersId=-1;      
    int appelEnchereId=-1;
    int stateVenteId=-1;

    public int getId() {
        return id;
    }
    public Users getUsers() throws Exception {
        Users vaovao = new Users();
        vaovao.setId(this.usersId);
        ArrayList<Users> cpt = vaovao.select(null);
        return cpt.get(0);
    }

    public AppelEnchere getAppelEnchere() throws Exception {
        AppelEnchere vaovao = new AppelEnchere();
        vaovao.setId(this.appelEnchereId);
        ArrayList<AppelEnchere> cpt = vaovao.select(null);
        return cpt.get(0);
    }
    
    public StateVente getStateVente() throws Exception {
        StateVente vaovao = new StateVente();
        vaovao.setId(this.appelEnchereId);
        ArrayList<StateVente> cpt = vaovao.select(null);
        return cpt.get(0);
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDateMise() {
        return dateMise;
    }

    public void setDateMise(String dateMise) {
        this.dateMise = dateMise;
    }

    public double getPrixMise() {
        return prixMise;
    }

    public void setPrixMise(double prixMise) {
        this.prixMise = prixMise;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getAppelEnchereId() {
        return appelEnchereId;
    }

    public void setAppelEnchereId(int appelEnchereId) {
        this.appelEnchereId = appelEnchereId;
    }

    public int getStateVenteId() {
        return stateVenteId;
    }

    public void setStateVenteId(int stateVenteId) {
        this.stateVenteId = stateVenteId;
    }
    
}
