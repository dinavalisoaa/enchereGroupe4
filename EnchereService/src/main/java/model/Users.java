/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.Connexion;
import BddObject.Ignore;
import BddObject.InfoDAO;
import BddObject.ObjectBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Users")
public class Users extends ObjectBDD {

    int id = -1;
    String nom;
    String login;
    String mdp;
    String prenom;
    private int genreid;
    private Date dtn;
    @Ignore
    private int enchereFait;
    @Ignore
    private int enchereGagner;
    @Ignore
    private int nbrechargeCompte;
   

    public int getId() {
        return id;
    }

    public Users getUsers() throws Exception {
//    ArrayList<Users>vao=()
        return ((Users) this.select(null).get(0));
    }

    public double getCurrentMoney() throws Exception {
        Compte cpt = new Compte();
        cpt.setUsersId(id);
        double montant = ((Compte) cpt.getLastObject()).getMontant();
        return montant;
    }

    public String getLogin() {
        return login;
    }

    public int getLoginId() throws Exception {
        this.setNom(nom);
        this.setLogin(login);
        if (this.select(null).size() > 0) {
            return ((Users) this.select(null).get(0)).getId();
        }
        return -1;
    }

    public Compte getCompte() throws Exception {
        Compte vaovao = new Compte();
        vaovao.setUsersId(this.id);
        ArrayList<Compte> cpt = vaovao.select(null);
        return cpt.get(0);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public static Users[] minieres() throws Exception {
        ArrayList lis = new Users().select(null);
        Users[] oo = new Users[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (Users) lis.get(i);
        }
        return oo;
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

    public ArrayList<Users> getEnchereVitany() throws SQLException {
        ArrayList<Users> valiny = new ArrayList();
        Connection connection = null;
        try {
            connection = Connexion.getConn();
            String sql = "select sum(isa)as som,usersid from (\n"
                    + "select count(usersid) as isa,enchereid,usersid from encheremove  \n"
                    + "group by enchereid,usersid\n"
                    + ")as b\n"
                    + "group by usersid";
            PreparedStatement preparedStatement = Connexion.getConn().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getInt("usersid"));
                //System.out.println(resultSet.getInt("usersid"));
                users.setEnchereFait(resultSet.getInt("som"));
                //System.out.println(resultSet.getInt("som"));
                valiny.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            connection.close();
            return valiny;
        }
    }

    public int getEnchereFait() {
        return enchereFait;
    }

    public void setEnchereFait(int enchereFait) {
        this.enchereFait = enchereFait;
    }

    public ArrayList<Users> getenchereGagner() throws SQLException {
        ArrayList<Users> valiny = new ArrayList();
        Connection connection = null;
        try {
            connection = Connexion.getConn();
            String sql = "select count(*) as sum,usersid from encheremove where state=1\n"
                    + "group by usersid";
            PreparedStatement preparedStatement = Connexion.getConn().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getInt("usersid"));
                //System.out.println(resultSet.getInt("usersid"));
                users.setEnchereGagner(resultSet.getInt("som"));
                //System.out.println(resultSet.getInt("som"));
                valiny.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            connection.close();
            return valiny;
        }
    }

    public Users getUserCompteLePlusRecharg() throws SQLException {
        Users valiny = null;
        Connection connection = null;
        try {
            connection = Connexion.getConn();
            String sql = "select count(*) as isa,usersid from compte\n"
                    + "group by usersid \n"
                    + "order by isa desc\n"
                    + "limit 1";
            PreparedStatement preparedStatement = Connexion.getConn().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getInt("usersid"));
                //System.out.println(resultSet.getInt("usersid"));
                users.setNbrechargeCompte(resultSet.getInt("som"));
                //System.out.println(resultSet.getInt("som"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            connection.close();
            return valiny;
        }
    }

    public int getEnchereGagner() {
        return enchereGagner;
    }

    public void setEnchereGagner(int enchereGagner) {
        this.enchereGagner = enchereGagner;
    }

    public int getNbrechargeCompte() {
        return nbrechargeCompte;
    }

    public void setNbrechargeCompte(int nbrechargeCompte) {
        this.nbrechargeCompte = nbrechargeCompte;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

   
}
