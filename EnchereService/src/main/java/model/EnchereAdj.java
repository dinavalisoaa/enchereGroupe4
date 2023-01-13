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
@InfoDAO(table = "EnchereAdj")
public class EnchereAdj extends ObjectBDD {

    int id = -1;
    int usersId=-1;      
    int enchereId=-1;
String dateAdj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getEnchereId() {
        return enchereId;
    }

    public void setEnchereId(int enchereId) {
        this.enchereId = enchereId;
    }

    public String getDateAdj() {
        return dateAdj;
    }

    public void setDateAdj(String dateAdj) {
        this.dateAdj = dateAdj;
    }
    public Users getUsers() throws Exception {
        Users vaovao = new Users();
        vaovao.setId(this.usersId);
        ArrayList<Users> cpt = vaovao.select(null);
        return cpt.get(0);
    }
}
