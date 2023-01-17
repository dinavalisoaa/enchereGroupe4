package model;

import BddObject.Connexion;
import BddObject.InfoDAO;
import BddObject.ObjectBDD;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Compte")
public class Compte extends ObjectBDD {    
    
    private int id = -1;
    private double montant = -1;
    private int usersId;
    private String dateReload;
    
    public double getMontant() {
        return montant;
    }

    public double getSumMoney() throws Exception {
        Compte vao = new Compte();
        List<Compte> avo = vao.select(null);
        double ii = 0;
        if (avo.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < avo.size(); i++) {
                Compte get = avo.get(i);
                ii += get.getMontant();
            }
        }
        return ii;
    }

    public void insert(Connection con) throws Exception {
        ObjectBDD bss=this.getLastObject();
        this.setMontant(((Compte)bss).getMontant() + this.montant);
        super.insert(null);
    }
    
    public void setMontant(double montant) {
        this.montant = montant;
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
    
    public double getNom() {
        return this.montant;
    }

    /**
     *
     * @param montant
     */
    /**
     *
     * @param usersId
     */
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }
    
    public int getUsersId() {
        return usersId;
    }
    
    public String getDateReload() {
        return this.dateReload;
    }

    /**
     *
     * @param dateReload
     */
    public void setDateReload(String dateReload) {
        this.dateReload = dateReload;
    }
    
}
