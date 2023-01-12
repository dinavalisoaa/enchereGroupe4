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
@InfoDAO(table = "StateVente")
public class StateVente extends ObjectBDD {

int id=-1;
String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
