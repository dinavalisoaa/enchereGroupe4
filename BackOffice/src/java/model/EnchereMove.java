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
@InfoDAO(table = "EnchereMove")
public class EnchereMove extends ObjectBDD {

    private String dateMise;
    private double prixMise = -1;
    private int state = -1;
    private int usersId = -1;
    private int enchereId = -1;
    private int id = -1;

    public String getDateMise() {
        return this.dateMise;
    }

    /**
     *
     * @param dateMise
     */
    public void setDateMise(String dateMise) {
        this.dateMise = dateMise;
    }

    public double getPrixMise() {
        return this.prixMise;
    }

    /**
     *
     * @param prixMise
     */
    public Users getUsers() throws Exception {
        Users us = new Users();
        us.setId(this.usersId);
        return ((Users) us.select(null).get(0));
    }

    public void setPrixMise(double prixMise) throws Exception {
        if (prixMise < this.getUsers().getCurrentMoney()) {
            throw new Exception("Solde inferieur");
        } else {
            this.prixMise = prixMise;
        }

    }

    public int getState() {
        return this.state;
    }

    /**
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    public int getUsersId() {
        return this.usersId;
    }

    /**
     *
     * @param usersId
     */
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getEnchereId() {
        return this.enchereId;
    }

    /**
     *
     * @param enchereId
     */
    public void setEnchereId(int enchereId) {
        this.enchereId = enchereId;
    }

    public int getId() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
