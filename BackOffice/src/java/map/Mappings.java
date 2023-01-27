/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

import java.util.HashMap;
import model.Admin;
import model.Categorie;
import pointdo.*;

/**
 *
 * @author dina
 */
public class Mappings {

    @Fonction(url = "/login")
    public ModelView login(@RequestParams(value = "login") String login,
            @RequestParams(value = "mdp") String mdp) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Admin add = new Admin();
        add.setLogin(login);
        add.setMdp(mdp);
        if (add.getLoginId() != -1) {
            returner.redirect("home.do");
            returner.session.setAttributes("id", add.getLoginId());
        }
        return returner;
    }

    @Fonction(url = "/home")
    public ModelView toHome() throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        returner.setPage("home.jsp"); 
        return returner;
    }

    @Fonction(url = "/categories")
    public ModelView cat() throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        returner.setPage("categories.jsp");
        return returner;
    }

    @Fonction(url = "/newCat")
    public ModelView newcat(@RequestParams(value = "nom") String nom) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Categorie cat = new Categorie();
        cat.setNom(nom);
        cat.insert(null);
        returner.redirect("categories.jsp");
        return returner;
    }

    @Fonction(url = "/delCat")
    public ModelView del(@RequestParams(value = "id") int id) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Categorie cat = new Categorie();
//        cat.setNom(nom);/
        cat.setId(id);
        cat.delete("id", null);
        returner.redirect("categories.jsp");
        return returner;
    } @Fonction(url = "/upCat")
    public ModelView upcat(@RequestParams (value = "nom")String nom) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Categorie cat=new Categorie();
        cat.setNom(nom);
        cat.insert(null);
        returner.redirect("categories.jsp");
        return returner;
    }
}
