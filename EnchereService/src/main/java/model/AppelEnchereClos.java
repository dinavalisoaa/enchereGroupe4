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
@InfoDAO(table = "AppelEnchereClos")
public class AppelEnchereClos extends ObjectBDD {
String dateClo;
int appelEnchereId=-1;
  public AppelEnchere getAppelEnchere() throws Exception {
        AppelEnchere vaovao = new AppelEnchere();
        vaovao.setId(this.appelEnchereId);
        ArrayList<AppelEnchere> cpt = vaovao.select(null);
        return cpt.get(0);
    }

    public String getDateClo() {
        return dateClo;
    }

    public void setDateClo(String dateClo) {
        this.dateClo = dateClo;
    }

    public int getAppelEnchereId() {
        return appelEnchereId;
    }

    public void setAppelEnchereId(int appelEnchereId) {
        this.appelEnchereId = appelEnchereId;
    }

}
