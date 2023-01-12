/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dina
 */
import BddObject.Ignore;
import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.util.ArrayList;

/**
 *
 * @author dina
 */
@InfoDAO(table = "ProduitUsers")
public class ProduitUsers extends ObjectBDD {

    int id=-1;
    int produitId=-1;
    int usersId=-1;
    public Users getUsers() throws Exception {
        Users vaovao = new Users();
        vaovao.setId(this.usersId);
        ArrayList<Users> cpt = vaovao.select(null);
        return cpt.get(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }
    
    
    public Produit getProduit() throws Exception {
        Produit vaovao = new Produit();
        vaovao.setId(this.usersId);
        ArrayList<Produit> cpt = vaovao.select(null);
        return cpt.get(0);
    }

//       public static String getNextValueSequence(Connection con)throws Exception{
//        String req="SELECT next value for seq_detailCom as id";
//        java.sql.Statement stmt=con.createStatement();
//        ResultSet res=stmt.executeQuery(req);
//        res.next();
//        return res.getString(1);
//    }
//    public static boolean estDejaAttribue(String idDetailCommande,Connection con)throws Exception{
//        String req="SELECT COUNT(*) as nb FROM AttributionCommande WHERE idDetailCommande='"+idDetailCommande+"'";
//        java.sql.Statement stmt=con.createStatement();
//        ResultSet res=stmt.executeQuery(req);
//        res.next();
//        int nb=Integer.valueOf(res.getString("nb"));
//        if(nb>0)return true;
//        return false;
//    }


}
