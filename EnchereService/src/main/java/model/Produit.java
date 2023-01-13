/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.Ignore;
import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.util.ArrayList;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Produit")
public class Produit extends ObjectBDD {

int id=-1;
String nom;
int Categorieid ;

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
    public int getCategorieid() {
        return Categorieid;
    }

    public void setCategorieid(int Categorieid) {
        this.Categorieid = Categorieid;
    }

}
