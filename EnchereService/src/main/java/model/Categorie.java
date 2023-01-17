
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

 public Categorie getCategorie() throws Exception{
//    ArrayList<Users>vao=()
return ((Categorie)this.select(null).get(0));
    }
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}