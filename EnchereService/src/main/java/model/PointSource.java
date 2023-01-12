/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.Ignore;
import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import utils.UFunction;

/**
 *
 * @author dina
 */
@InfoDAO(table = "PointSource")
public class PointSource extends ObjectBDD {

    int id;
    int miniereId;
    double posX;
    double posY;
    String nom;
    @Ignore
    Fitotona[] fitotonas;
    @Ignore
    PointSource choix;

    public Fitotona[] getFitotonas() {
        return fitotonas;
    }

    public void setFitotonas(Fitotona[] fitotonas) {
        this.fitotonas = fitotonas;
    }

    public boolean getPossible(int mois,int freq, double montan_entrer) throws Exception {
        double vola_vitany = this.getBene(mois,Integer.toString(freq), null);
        if(montan_entrer==131000000){
            return false;
        }
        else if (montan_entrer <= vola_vitany) {
            return true;
        }
        return false;
    }

//    public PointSource[] getChoix(int freq, double montan_entrer) throws Exception {
//        PointSource[] source = PointSources();
//        ArrayList<PointSource> all = new ArrayList<>();
//        for (int i = 0; i < source.length; i++) {
//            PointSource pointSource = source[i];
//            double vola_vitany = pointSource.getBene(Integer.toString(freq), null);
//            if (montan_entrer <= vola_vitany) {
//                all.add(pointSource);
//            }
//        }
//    }

    public void setChoix(PointSource choix) {
        this.choix = choix;
    }

    public Object[] getVolamenaObtenu() throws Exception {
        Produit fits = new Produit();
        fits.setPointSourceId(this.id);
        ArrayList fitotona = fits.select(null);
        return fitotona.toArray();
    }

    public double getDepensesJournalier(int mois,Connection con) throws Exception {
        double gasoil = Gasoil.getGasoilParJour(con);
        double main = new Maintenance().getMainteJour(mois,con);
        double sala = new Salaire().getSalaireJour(mois);
        System.out.println("[>Cout Gasoil:" + gasoil +"Ar/j <]  [> Maintenance: " + main + "Ar/j <] [> Salaire: " + sala+"Ar <]");
        return gasoil + main + sala;
    }

//    public double getDepense(Connection con) throws Exception {
//        Object[] dina = getFitotonas(con);
//        double somme = 0.0;
//        for (int i = 0; i < dina.length; i++) {
//            Fitotona object = (Fitotona) dina[i];
////            somme += new Double(object.getDurerFitotona() * new Gasoil().getValeurGasoil());
//        }
//        PointSource pts = new PointSource();
//        pts.setId(this.id);
////        System.out.println("Sample"+somme);
//        double val = pts.getDurer(con) * new Gasoil().getValeurGasoil();
//        System.out.println("__" + pts.getDurer(con));
//        return (val) * new Broyeur().getConsommation();
//    }

    public double getVidinaVolamena() throws Exception {
        return new PrixVolamena().getMontantFarany();
    }

    public double getGainJournaliere(String fre, Connection con) throws Exception {
        double effic = getEfficaciteJournalier(con) * new PrixVolamena().getMontantFarany();
        System.out.println("Vola azo 1j :" + effic);
        return Integer.valueOf(fre) * effic;
    }
/*
    @d
    */
    
    public double getDureteParFreq(String fre, Connection con) throws Exception {
        double effic = getDureteJournalier(con); //* new PrixVolamena().getMontantFarany();
        System.out.println("Volamena  azo 1j :" + effic + " g/j");
        return Integer.valueOf(fre)*effic;
    }

    public double getEffi(String fre, Connection con) throws Exception {
        double effic = getEfficaciteJournalier(con); //* new PrixVolamena().getMontantFarany();
        System.out.println("Volamena  azo 1j :" + effic + " g/j");
        return Integer.valueOf(fre) * effic;
    }
    public double getBene(int mois,String fre, Connection con) throws Exception {
        double gain = getGainJournaliere(fre, con);
        double doune = getDepense(mois,fre, con);
        System.out.println("DEP " + NumberFormat.getInstance().format(doune));
        System.out.println("GAIN " + NumberFormat.getInstance().format(gain));
        double durete_freq = this.getDureteJournalier(con) * Integer.valueOf(fre);
        System.err.println(this.getDureteHoraire(con) + "PROPOS: " + durete_freq + "t tokony toto");
        return gain - doune;
    }

    public Object[] getFitotonas(Connection con) throws Exception {
        Fitotona fits = new Fitotona();
        fits.setPointSourceId(this.id);
        ArrayList fitotona = fits.select(con);
        return fitotona.toArray();
    }

    public Object[] getExplosions(Connection con) throws Exception {
        Explosion fits = new Explosion();
        fits.setPointSourceId(this.id);
        ArrayList fitotona = fits.select(null);
        return fitotona.toArray();
    }
public Object[] getCentriGlobal(Connection con) throws Exception {
        Produit_Users fits = new Produit_Users();
        ArrayList fitotona = fits.select(con);
        return fitotona.toArray();
    }
    public Object[] getCentri(Connection con) throws Exception {
        Produit_Users fits = new Produit_Users();
        fits.setPointSourceId(this.id);
        ArrayList fitotona = fits.select(con);
        return fitotona.toArray();
    }

    public double getVatoExploser(Connection con) throws Exception {
        Object[] dina = getExplosions(con);
        double somme = 0.0;
        for (int i = 0; i < dina.length; i++) {
            Explosion object = (Explosion) dina[i];
            somme += object.getQteVato();
        }
        return somme;
    }

    public double getDurer(Connection con) throws Exception {
        Object[] dina = getFitotonas(con);
        double somme = 0.0;
        for (int i = 0; i < dina.length; i++) {
            Fitotona object = (Fitotona) dina[i];
            somme += object.getDurerFitotona();
        }
        return somme;
    }

    public double ratio(Connection con) throws Exception {
        Object[] dina = getCentri(con);
        double somme = 0.0;
        for (int i = 0; i < dina.length; i++) {
            Produit_Users object = (Produit_Users) dina[i];
//            System.out.println("QTE V:" + object.getVolamena().getQteVolamena() + " QTE t/h::" + this.getMoyenneDureteHoraire(con) + " QTE C:" + object.getQteVato() + " = " + new Double(object.getVolamena().getQteVolamena() * this.getMoyenneDureteHoraire(con) / object.getQteVato()));
            somme += new Double(object.getVolamena().getQteVolamena() /**
                     * this.getMoyenneDureteHoraire(con)
                     */
                    / object.getQteVato());
        }
        double f = somme / dina.length;   
//        System.out.println("Prop: g/t" + f);
        return f;
    }
//    
//    0.4 t -->4g
//     0.4625 t ?       

    public double totalVolamena() throws Exception {
        Object[] dina = getVolamenaObtenu();
        double somme = 0.0;
        for (int i = 0; i < dina.length; i++) {
            Produit object = (Produit) dina[i];
            somme += object.getQteVolamena();
        }
        return somme;
    }

    public double getEfficaciteHoraire(Connection con) throws Exception {
        System.out.println("Proportion:  " + this.ratio(con) + "g/t");
        return this.ratio(con) * this.getDureteHoraire(con);
    }

//    12g  ---> 1
//      ?       0.12T   
    public double getBeneficeJournalier(int mois,Connection con)throws Exception{
       double gain=getGainJournaliere("1", con);
              double dep=getDepensesJournalier( mois,con);
return gain-dep;
    }
    
    public double getEfficaciteJournalier(Connection con) throws Exception {
        double f = this.getEfficaciteHoraire(con) * 8;
//        System.out.println("Effi/h: " + new Double(f / 8));
        System.out.println("[[ Efficacite /j: " + new Double(f)+" ]]");
        return f;
    }
    public double getDureteToto(Connection con) throws Exception {
        Object[] dina = getFitotonas(con);
        double somme = 0.0;
        for (int i = 0; i < dina.length; i++) {
            Fitotona object = (Fitotona) dina[i];
            somme += (object.getQteVato() / object.getDurerFitotona());
//            System.out.println("model.PointSource.getDureteToto()"+object.getQteVato()+"/"+object.getDurerFitotona());
        }
        return somme / dina.length;
    }
    //9,25 g ---->t
    // 0.4625 t/ 

//0.2T    3g
    /// 0.4625   
    public static double[] tridouble(double[] lp) throws Exception {
//        PointSource[] lp = this.getPointSources();
        if (lp != null) {
            int i = 0;
            while (i < lp.length) {
                double p = lp[i];
                int j = i;
                while (j > 0 && (lp[j - 1]) < p) {
                    lp[j] = lp[j - 1];
                    j--;
                }
                lp[j] = p;
                i++;
            }
        }
        return lp;
    }
      public double getDepenseMainteParFreq(int mois,String fre, Connection con) throws Exception {
        double main = new Maintenance().getMainteJour(mois,con);
        double sala = new Salaire().getSalaireJour(mois);
//        double par_jour = new Double(dep / 22);
        System.err.println("[[Maintenance en "+fre+" jour:: "+main+"]]");
        return main*Integer.valueOf(fre);
    }
    public double getDepenseGasoilParFreq(int mois,String fre, Connection con) throws Exception {
            double gasoil = Gasoil.getGasoilParJour(con);
        double main = new Maintenance().getMainteJour(mois,con);
        double sala = new Salaire().getSalaireJour(mois);
//        double par_jour = new Double(dep / 22);
        System.err.println("[[Gasoil en "+fre+" jour:: "+gasoil+"]]");
        return gasoil*Integer.valueOf(fre);
    }
    public double getDepense(int mois,String fre, Connection con) throws Exception {
        double dep = getDepensesJournalier(mois,con);
//        double par_jour = new Double(dep / 22);
        System.err.println("[[Depense en 1 jour:: "+dep+"]]");
        return dep*UFunction.count_niasa(mois);
    }
    public double getDureteJournalier(Connection con) throws Exception{
        return this.getDureteHoraire(con)*8;
    }
    public double getDureteHoraire(Connection con) throws Exception {
//                double[] dod = new double[]{getDureteCentrifugeParLavaka(con), getDureteToto(con)};
// System.out.println("min{" + getDureteCentrifugeParLavaka(con) + "," + getDureteToto(con) + "}");
       double[] dod = new double[]{getDureteCentrifugeGlobal(con), getDureteToto(con)};
        System.out.println("min{" + getDureteCentrifugeGlobal(con) + "," + getDureteToto(con) + "}");
        return tridouble(dod)[1];
    } 
    public double getDureteCentrifugeParLavaka(Connection con) throws Exception {
        Object[] dina = getCentri(con);
        double somme = 0.0;
        for (int i = 0; i < dina.length; i++) {
            Produit_Users object = (Produit_Users) dina[i];
            somme += (object.getQteVato() / object.getDurerCentrifuge());
//            System.out.println("model.PointSource.getDureteToto()"+object.getQteVato()+"/"+object.getDurerFitotona());
        }
        return somme / dina.length;
    }
  
    public double getDureteCentrifugeGlobal(Connection con) throws Exception {
        Object[] dina = getCentriGlobal(con);
        double somme = 0.0;
        for (int i = 0; i < dina.length; i++) {
            Produit_Users object = (Produit_Users) dina[i];
            somme += (object.getQteVato() / object.getDurerCentrifuge());
        }
        return somme / dina.length;
    }

    public double getMoyenneDureteHoraire(Connection con) throws Exception {
//        Double d = new Double(this.getDureteToto(con));
        return this.getDureteHoraire(con);//this.getDurer();
    }
//4÷1,61
//    4 h --> 1.61
//    1 -?

    public Users getMiniere() throws Exception {
        Users vaovao = new Users();
        vaovao.setId(this.miniereId);
        ArrayList<Users> cpt = vaovao.select(null);
        return cpt.get(0);
    }

    public int getMiniereId() {
        return miniereId;
    }

    public void setMiniereId(int miniereId) {
        this.miniereId = miniereId;
    }
//    
// public  Fitotona[]getFitotonas() throws Exception{
//     Explosion vao=new Explosion();
//     ArrayList<Fitotona> fit=new ArrayList<>();
//     vao.setPointSourceId(this.id);
//     ArrayList list=vao.select(null); 
//     for (int i = 0; i < list.size(); i++) {
//        Explosion get = (Explosion)list.get(i);
//       Fitotona[]exps=get.getFitotonas();
//         for (int j = 0; j < exps.length; j++) {
//             Fitotona exp = exps[j];
//             fit.add(exp);
//         }
// }
//     Fitotona[]oo=new Fitotona[fit.size()];
//       for (int i = 0; i <oo.length; i++) {
//           oo[i]=(Fitotona)fit.get(i);
//       }
//     return oo;
// }

    public static PointSource[] PointSources() throws Exception {
        ArrayList lis = new PointSource().select(null);
        PointSource[] oo = new PointSource[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (PointSource) lis.get(i);
        }
        return oo;
    }

    public static PointSource[] PointSourcesNotNull() throws Exception {
        ArrayList lis = new PointSource().selectBySQL("select *from pointsource", null);
        PointSource[] oo = new PointSource[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (PointSource) lis.get(i);
        }
        return oo;
    }

    public PointSource() {
        this.id = -1;
        this.miniereId = -1;
        this.posX = -1.0;
        this.posY = -1.0;
    }

    public int getId() {
        return id;
    }

    public static double getRatio(int id) {
        Connection connect = null;
        Statement stmt = null;
        ResultSet res = null;
        String date = "";
        double n = 0.0;
        ResultSetMetaData resultMeta = null;
        PreparedStatement pst = null;
        try {
//            connect = Connexion.getConn();
////            pst = connect.prepareStatement("select (sum(v.qtevolamena)/(1000*1000))/sum(c.qtevato) as sum from centrifuge c join explosion ex on c.explosionid=ex.id join pointsource p on c.explosionid=ex.id full join volamena v on v.explosionid=ex.id where ex.pointsourceid=" + id);
//            res = pst.executeQuery();
////             System.out.println("model.PointSource.getRatio()");
//            resultMeta = res.getMetaData();
//            int b = 0;
//            while (res.next()) {
//                n = res.getDouble("sum");
//            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (res != null) {
                try {
                    res.close();
                    pst.close();
                    connect.close();
                } catch (SQLException ex) {
                }
            }
        }

        return n;
    }
//    select (sum(qtevolamena))/(sum(qtevato)*(1000*1000)) as sum  from volamena v join explosion ex on ex.id=v.explosionId where  ex.pointsourceid=3  group by v.id;

    public void setId(int id) {
        this.id = id;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
