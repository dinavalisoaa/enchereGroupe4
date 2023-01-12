/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dina
 */
import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.util.ArrayList;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Broyeur")
public class Broyeur extends ObjectBDD {

    int id = -1;
    double consom = -1.0;
//public Broyeur(int)
    public int getId() {
        return id;
    }
    public double getConsommation() throws Exception {
        ArrayList<Broyeur> li = new Broyeur().select(null);
        return li.get(0).getConsom();
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getConsom() {
        return consom;
    }

    public void setConsom(double consom) {
        this.consom = consom;
    }

}
