
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
import java.util.Arrays;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Categorie")
public class Categorie extends ObjectBDD {
	private int id=-1;
	private String nom;
        @Ignore
        private int persInteresser;

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

    public int getPersInteresser() {
        return persInteresser;
    }

    public void setPersInteresser(int persInteresser) {
        this.persInteresser = persInteresser;
    }
        public Categorie getUserCompteLePlusRecharg() throws SQLException {
        Categorie valiny = null;
        Connection connection = null;
        try {
            connection = Connexion.getConn();
            String sql = "";
            PreparedStatement preparedStatement = Connexion.getConn().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Categorie categorie = new Categorie();
                categorie.setId(resultSet.getInt("categorieid"));
                //System.out.println(resultSet.getInt("usersid"));
                categorie.setPersInteresser(resultSet.getInt("isa"));
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
        
}