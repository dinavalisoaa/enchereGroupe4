
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
@InfoDAO(table = "Categorie")
public class Categorie extends ObjectBDD {
	private int id=-1;
	private String nom;

	public int getId() {
		return this.id;
	}

    public static Categorie[] categories() throws Exception {
        ArrayList lis = new Categorie().select(null);
        Categorie[] oo = new Categorie[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (Categorie) lis.get(i);
        }
        return oo;
    }
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}