
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
@InfoDAO(table = "EnchereClose")
public class EnchereClose extends ObjectBDD {  

	private String dateClose;
	private int enchereId=-1;

	public String getDateClose() {
		return this.dateClose;
	}

	/**
	 * 
	 * @param dateClose
	 */
	public void setDateClose(String dateClose) {
		this.dateClose = dateClose;
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

}