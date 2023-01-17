
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
@InfoDAO(table = "EncherePhoto")
public class EncherePhoto extends ObjectBDD {  

	private int enchereId=-1;
	private String path;
	private String photo;

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

	public String getPath() {
		return this.path;
	}

	/**
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	public String getPhoto() {
		return this.photo;
	}

	/**
	 * 
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}