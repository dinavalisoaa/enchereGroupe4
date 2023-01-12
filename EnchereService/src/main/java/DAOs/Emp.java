/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import pointdo.*;
/**
 *
 * @author dina
 */
public class Emp {
    int id=0;
    String nom;
    @Fonction(url = "getId-Emp")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Fonction(url = "/getNom-Emp")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
