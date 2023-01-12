/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import utils.UFunction;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Personne")
public class Personne extends ObjectBDD {
int id=-1;
String nom;
String prenom;
String dtn;
String adresse;
String sexe;

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public int getId() {
        return id;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDtn() {
        return dtn;
    }

    public void setDtn(String dtn) {
        this.dtn = dtn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public static Personne[] Personnes() throws Exception {
        ArrayList lis = new Personne().selectBySQL("select *from personne", null);
        Personne[] oo = new Personne[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (Personne) lis.get(i);
        }
        return oo;
    }
    public Personne getPersonnes() throws Exception {
        ArrayList lis = this.select( null);
       
        return ((Personne)lis.get(0));
    }

}
