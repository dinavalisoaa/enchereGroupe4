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
@InfoDAO(table = "Users")
public class Users extends ObjectBDD {

    int id = -1;
    String nom;
    String login;
    String mdp;
    String prenom;
    public int getId() {
        return id;
    }
    public double getCurrentMoney() throws Exception{
        Compte  cpt=new Compte();
        cpt.setUsersId(id);
        double montant=((Compte)cpt.getLastObject()).getMontant();
        return montant;
    }
    public String getLogin() {
        return login;
    }
    
public int getLoginId() throws Exception{
    this.setNom(nom);
    this.setLogin(login);
    if(this.select(null).size()>0){
        return ((Users)this.select(null).get(0)).getId();
    }
    return -1;
}
  public Compte getCompte() throws Exception {
        Compte vaovao = new Compte();
        vaovao.setUsersId(this.id);
        ArrayList<Compte> cpt = vaovao.select(null);
        return cpt.get(0);
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


   


    public static Users[] minieres() throws Exception {
        ArrayList lis = new Users().select(null);
        Users[] oo = new Users[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (Users) lis.get(i);
        }
        return oo;
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
