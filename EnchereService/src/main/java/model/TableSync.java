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
@InfoDAO(table = "TableSync")
public class TableSync extends ObjectBDD {
int id=-1;
String sql;
int etat=-1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

public static TableSync[] TableSyncs() throws Exception {
        ArrayList lis = new TableSync().selectBySQL("select *from tablesync where etat=0", null);
        TableSync[] oo = new TableSync[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (TableSync) lis.get(i);
            oo[i].setSql(oo[i].getSql().replaceAll("`","'"));
        }
        return oo;
    }
}
