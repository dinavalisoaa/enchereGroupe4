/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.awt.CardLayout;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.swing.JFrame;
import model.Centrifuge;
import model.Explosion;
import model.Fitotona;
import model.Personne;
import model.PointSource;
import model.TableSync;
import model.Volamena;
import pointdo.*;
import static utils.UFunction.count_niasa;

/**
 *
 * @author dina
 */
public class Mappings {

    @Fonction(url = "/liste-Compte")
    public ModelView getListCompte(@SessionArgs(value = "") String d) throws Exception {
        ModelView returner = new FrontServlet().load;
        returner.setPage("index.jsp?compte=" + d);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("id", 12);
        returner.setData(data);
        returner.session.setAttributes("karen", 3);
        returner.session.destroy("karen");
        return returner;
    }

    @Fonction(url = "/saisie-Centrifuge")
    public ModelView toForm() throws Exception {
        ModelView returner = new ModelView();
        returner.setPage("saisieCentrifuge.jsp");
        return returner;
    } @Fonction(url = "/majPersonne")
    public ModelView editsePersonne(@RequestParams(value = "id") int id,
            @RequestParams(value = "nom") String nom,
            @RequestParams(value = "prenom") String prenom,
            @RequestParams(value = "dtn") String dtn,
            @RequestParams(value = "sexe") String sexe,
            @RequestParams(value = "adresse") String adresse) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Personne io = new Personne();
        io.setId(id);
        Personne les_personne = io.getPersonnes();
        data.put("personne", les_personne);
        data.put("id", id);
          Personne ios = new Personne();
        ios.setDtn(dtn);
        ios.setNom(nom);
        ios.setPrenom(prenom);
        ios.setAdresse(adresse);
        ios.setSexe(sexe);
        ios.setId(id);
        ios.update("id",null);
        String sql = ios.update("id");
        sql = sql.replaceAll("'", "`");
        TableSync ss = new TableSync();
        ss.setSql(sql);
        ss.setId(utils.UFunction.getSequence_Sync());
        ss.setEtat(0);
        ss.insert(null);    
        returner.redirect("all-Personne.do");

        return returner;
    }
  @Fonction(url = "/delPersonne")
    public ModelView deletePersonne(@RequestParams(value = "id") int id) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Personne io = new Personne();
        io.setId(id);
        Personne les_personne = io.getPersonnes();
        data.put("personne", les_personne);
        data.put("id", id);
          Personne ios = new Personne();
        ios.setId(id);
        ios.delete("id",null);
        
        String sql = ios.delete("id");
        sql = sql.replaceAll("'", "`");
        TableSync ss = new TableSync();
        ss.setSql(sql);
        ss.setId(utils.UFunction.getSequence_Sync());
        ss.setEtat(0);
        ss.insert(null);    
        returner.redirect("all-Personne.do");

        return returner;
    }
    @Fonction(url = "/edit-Personne")
    public ModelView editePersonne(@RequestParams(value = "id") int id) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Personne io = new Personne();
        io.setId(id);
        Personne les_personne = io.getPersonnes();
        data.put("personne", les_personne);
        data.put("id", id);
        returner.setData(data);
        returner.setPage("edit-personne.jsp");
        return returner;
    }

    @Fonction(url = "/insererPersonne")
    public ModelView insererPersonne(@RequestParams(value = "nom") String nom,
            @RequestParams(value = "prenom") String prenom,
            @RequestParams(value = "dtn") String dtn,
            @RequestParams(value = "sexe") String sexe,
            @RequestParams(value = "adresse") String adresse) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Personne io = new Personne();
        io.setDtn(dtn);
        io.setNom(nom);
        io.setPrenom(prenom);
        io.setAdresse(adresse);
        io.setSexe(sexe);
//        io.setId(utils.UFunction.getSequence());
        io.insert(null);
//        System.err.println();
        String sql = io.insertion();
        sql = sql.replaceAll("'", "`");
        System.err.println("[" + sql + "]");
        TableSync ss = new TableSync();
        ss.setSql(sql);
        ss.setId(utils.UFunction.getSequence_Sync());
        ss.setEtat(0);
        ss.insert(null);
//        returner.setData(data);
        returner.redirect("all-Personne.do");
        return returner;
    }

    @Fonction(url = "/estimation-Lavaka")
    public ModelView est(@RequestParams(value = "montant") double montant,
            @RequestParams(value = "frequence") int freq,
            @RequestParams(value = "mois") int mois) throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        if (freq == 22) {
            freq = count_niasa(mois);
        }
        data.put("frequence", freq);
        data.put("montant", montant);
        data.put("mois", mois);

        returner.setData(data);
        returner.setPage("estimation.jsp");
        return returner;
    }

    @Fonction(url = "/all-Personne")
    public ModelView all_sd() throws Exception {
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
        Personne[] les_personne = Personne.Personnes();
        data.put("personne", les_personne);
        returner.setData(data);
        returner.setPage("personne.jsp");
        return returner;
    }
//    

    @Fonction(url = "/ouvrir-Win")
    public ModelView get(@RequestParams(value = "idMiniere") int idPt) {
//        ouvrir-Win.do?idMinier
        ModelView returner = new ModelView();
        HashMap<String, Object> data = new HashMap<String, Object>();
//        data.put("pts", list);
        JFrame frame = new JFrame();
        frame.setSize(1000, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // un panneau pour y mettre les différents composants à afficher, avec un cardlayout
        CardLayout cardLayout = new CardLayout();
//        Board panel = new Board();
//        Couche1 p=new Couche1();
//        frame.getContentPane().add(panel); // on le met au centre du content pane de la fenêtre pour qu'il soit affiché

        returner.setData(data);
        returner.setPage("saisiePointSource.jsp");
        return returner;
    }

    @Fonction(url = "/choix-Point")
    public ModelView choixPt(@RequestParams(value = "idPt") int idPt) throws Exception {
        ModelView returner = new ModelView();
        PointSource scr = new PointSource();
        scr.setMiniereId(idPt);
        ArrayList list = scr.select(null);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("pts", list);
        returner.setData(data);
        returner.setPage("saisiePointSource.jsp");
        return returner;
    }

    @Fonction(url = "/efficacite-Point")
    public ModelView efficacite(@RequestParams(value = "idMiniere") int idMiniere) throws Exception {
        ModelView returner = new ModelView();
        PointSource p = new PointSource();
        p.setMiniereId(idMiniere);
        ArrayList hh = p.select(null);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("lavaka", hh);
        returner.setData(data);

        returner.setPage("efficacite.jsp");

        return returner;
    }

    @Fonction(url = "/new-Broyage")
    public ModelView choixPt2(@RequestParams(value = "idPts") int idPt) throws Exception {
        ModelView returner = new ModelView();
        PointSource p = new PointSource();
        p.setId(idPt);
        Explosion exps = new Explosion();
        exps.setPointSourceId(idPt);

        Fitotona fits = new Fitotona();
        fits.setPointSourceId(idPt);
        ArrayList fitotona = fits.select(null);
        ArrayList exp = exps.select(null);

        Centrifuge cf = new Centrifuge();
        cf.setPointSourceId(idPt);

        Volamena vola = new Volamena();
        vola.setPointSourceId(idPt);

        PointSource list = (PointSource) p.select(null).get(0);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("pointsource", list);
        data.put("fitotona", fitotona);
        data.put("volamena", vola.select(null));
        data.put("centrifuge", cf.select(null));
        data.put("exp", exp);
        returner.setData(data);
        returner.setPage("saisieFitotona.jsp");

        return returner;
    }

    @Fonction(url = "/new-Centrifuge")
    public ModelView choixPt(@RequestParams(value = "pointSourceId") int pts,
            @RequestParams(value = "qteVato") double qtevato,
            @RequestParams(value = "volamena") double volamena,
            @RequestParams(value = "debut") String debut,
            @RequestParams(value = "fin") String fin) throws Exception {
        ModelView returner = new ModelView();
        Centrifuge vaovao = new Centrifuge();
        vaovao.setPointSourceId(pts);
        vaovao.setQteVato(qtevato);
        vaovao.setDebut(debut);
        vaovao.setFin(fin);
        vaovao.insert(null);
        Centrifuge ob = (Centrifuge) vaovao.getLastObject();
        Volamena vola = new Volamena();
        vola.setDaty(fin.split(" ")[0]);
        vola.setQteVolamena(volamena);
        vola.setPointSourceId(pts);
        vola.setCentrifugeId(ob.getId());
        vola.insert(null);
        returner.redirect("new-Broyage.do?idPts=" + pts);
        return returner;
    }

    @Fonction(url = "/delete-Fitotona")
    public ModelView choixPt(@RequestParams(value = "idPts") int pts,
            @RequestParams(value = "idFito") int fito) throws Exception {
        Fitotona uu = new Fitotona();
        uu.setId(fito);
        uu.execBySQL("delete from fitotona where id=" + fito, null);
//         uu.delete("id",null);
        ModelView returner = new ModelView();
        returner.redirect("new-Broyage.do?idPts=" + pts);
        return returner;
    }

    @Fonction(url = "/inserer-Explosion")
    public ModelView insererToto(@RequestParams(value = "idPts") int idPt, @RequestParams(value = "idMiniere") int idMiniere) throws Exception {
        ModelView returner = new ModelView();
        PointSource p = new PointSource();
        p.setId(idPt);
        Explosion exps = new Explosion();
        exps.setPointSourceId(idPt);

        Fitotona fits = new Fitotona();
        fits.setPointSourceId(idPt);
        ArrayList fitotona = fits.select(null);
//        ArrayList exp = exps.select(null);

        Centrifuge cf = new Centrifuge();
        cf.setPointSourceId(idPt);

        Volamena vola = new Volamena();
        vola.setPointSourceId(idPt);
        PointSource list = (PointSource) p.select(null).get(0);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("pointsource", list);
        data.put("fitotona", fitotona);
        data.put("volamena", vola.select(null));
        data.put("centrifuge", cf.select(null));
//        data.put("exp", exp);
        returner.setData(data);

        returner.setPage("saisieExplosion.jsp");
        return returner;
    }

    @Fonction(url = "/insert-Point")
    public ModelView insertPt() throws Exception {
        ModelView returner = new ModelView();
        PointSource scr = new PointSource();
//        scr.setMiniereId(idPt);
        ArrayList list = scr.select(null);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("pts", list);
        returner.setData(data);
        returner.setPage("saisiePointSource.jsp");
        return returner;
    }

    @Fonction(url = "/saisie-Miniere")
    public ModelView saisieMiniere() throws Exception {
        ModelView returner = new ModelView();
        returner.setPage("saisieMiniere.jsp");
        return returner;
    }
//       @Fonction(url = "/saisie-Miniere")
//    public ModelView saisieMiniere() throws Exception {
//        ModelView returner = new ModelView();
//         returner.setPage("saisieMiniere.jsp");
//        return returner;
//    }

    @Fonction(url = "/form-Compte2")
    public ModelView toForm2(@SessionArgs(value = "karen") String d) throws Exception {
        ModelView returner = new ModelView();
        returner.setPage("form.jsp?d=" + d);
        return returner;
    }

    @Fonction(url = "/g-Compte")
    public ModelView g(@RequestParams(value = "ID") int ID) throws Exception {
        ModelView returner = new ModelView();
        returner.setPage("form.jsp?ID=" + ID);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("message", "success");
        returner.setData(data);
        return returner;
    }
//
//    @Fonction(url = "/save-Compte")
//    public ModelView saveCompte(@RequestParams(value = "intitule") String intitule,
//            @RequestParams(value = "num") String numm,
//            @RequestParams(value = "ID") int ID,
//            @RequestParams(value = "timestamp") Timestamp times,
//            @RequestParams(value = "time") Time ora,
//            @RequestParams(value = "checkbox[]") String[] check,
//            @RequestParams(value = "date") Date daty,
//            @RequestParams(value = "valeur") double valeur) throws Exception {
//        ModelView returner = new ModelView();
//        this.setIntitule(intitule);
//        this.setDaty(daty);
//        this.setOra(times);
//        this.setInstant(ora);
//        this.setValeur(valeur);
//        this.setNumCompte(numm);
//        returner.setPage("form.jsp");
//        HashMap<String, Object> data = new HashMap<String, Object>();
//        data.put("message", "success");
////        data.put("id", 12);
//        returner.setData(data);
//        return returner;
//    }
//
//    public String getNumCompte() {
//        return numCompte;
//    }
//
//    public void setNumCompte(String numCompte) {
//        this.numCompte = numCompte;
//    }
//
//    public String getIntitule() {
//        return intitule;
//    }
//
//    public void setIntitule(String intitule) {
//        this.intitule = intitule;
//    }

}
