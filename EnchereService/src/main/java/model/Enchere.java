
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
@InfoDAO(table = "Enchere")
public class Enchere extends ObjectBDD {  

	private int id=-1;
	private double prixMin=-1;
	private String dateDebut;
	private String dateExp;
	private int usersId=-1;
	private int categorieId=-1;
	private int state=-1;
	private String descriProduit;
	private double durer=-1;

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

	public double getPrixMin() {
		return this.prixMin;
	}

	/**
	 * 
	 * @param prixMin
	 */
	public void setPrixMin(double prixMin) {
		this.prixMin = prixMin;
	}

	public String getDateDebut() {
		return this.dateDebut;
	}

	/**
	 * 
	 * @param dateDebut
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateExp() {
		return this.dateExp;
	}

	/**
	 * 
	 * @param dateExp
	 */
	public void setDateExp(String dateExp) {
		this.dateExp = dateExp;
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

	public int getCategorieId() {
		return this.categorieId;
	}

	/**
	 * 
	 * @param categorieId
	 */
	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
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

	public String getDescriProduit() {
		return this.descriProduit;
	}

	/**
	 * 
	 * @param descProduit
	 */
	public void setDescriProduit(String descProduit) {
		this.descriProduit = descProduit;
	}

	public double getDurer() {
		return this.durer;
	}

	/**
	 * 
	 * @param durer
	 */
	public void setDurer(double durer) {
		this.durer = durer;
	}

}