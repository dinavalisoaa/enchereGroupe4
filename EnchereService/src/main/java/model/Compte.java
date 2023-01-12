/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.InfoDAO;
import BddObject.ObjectBDD;
import java.sql.Connection;
import java.util.ArrayList;
import model.*;
import BddObject.Ignore;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Compte")
public class Compte extends ObjectBDD {
int id=-1;
String intitule;
@Ignore
double hay;
//public Compte(int d,char s){}
    public double getHay() {
        return hay;
    }

    public void setHay(double hay) {
        this.hay = hay;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
  
}
