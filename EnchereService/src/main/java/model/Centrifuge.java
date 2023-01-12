/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dina
 */
import DAObject.*;
import java.util.ArrayList;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Centrifuge")
public class Centrifuge extends ObjectBDD {

    int id=-1;
    int pointSourceId=-1;

    double qteVato=-1.0;
    String debut;
    String fin;
    @Ignore
    double durerCentrifuge;
    public double getDurerCentrifuge() {
        return utils.UFunction.timestampDiff(this.debut, this.fin);
    }

    public void setDurerCentrifuge(double durerCentrifuge) {
        this.durerCentrifuge = durerCentrifuge;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPointSourceId() {
        return pointSourceId;
    }

    public void setPointSourceId(int pointSourceId) {
        this.pointSourceId = pointSourceId;
    }
    public double getQteVato() {
        return qteVato;
    }

    public void setQteVato(double qteVato) {
        this.qteVato = qteVato;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
   
//
//    public Centrifuge getCentrifuge() throws Exception {
//        Centrifuge vaovao = new Centrifuge();
//        vaovao.setId(this.fitotonaId);
//        ArrayList<Centrifuge> cpt = vaovao.select(null);
//        return cpt.get(0);
//    }

  
//
//    public PointSource getPointSource() throws Exception {
//        return this.getCentrifuge().getPointSource();
//    }
  
    public Volamena getVolamena() throws Exception {
        Volamena vaovao = new Volamena();
        vaovao.setCentrifugeId(this.id);
        ArrayList<Volamena> cpt = vaovao.select(null);
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
