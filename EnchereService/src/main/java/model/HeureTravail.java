/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

import BddObject.InfoDAO;
import BddObject.ObjectBDD;

/**
 *
 * @author dina
 */
@InfoDAO(table = "HeureTravail")
public class HeureTravail extends ObjectBDD {
int id=-1;
double horaire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHoraire() {
        return horaire;
    }

    public void setHoraire(double horaire) {
        this.horaire = horaire;
    }

}
