/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.Ignore;
import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.util.ArrayList;

/**
 *
 * @author dina
 */
@InfoDAO(table = "Fitotona")
public class Fitotona extends ObjectBDD {

    int id=-1;
    
    String debut;
    String fin;
        double qteVato=-1;
    int pointSourceId=-1;
    @Ignore
    double durerFitotona;
    public double getDurerFitotona() {
        return utils.UFunction.timestampDiff(this.debut, this.fin);
    }

    public void setDurerFitotona(double durerFitotona) {
        this.durerFitotona = durerFitotona;
    }

    public Fitotona() {
        this.id = -1;
        this.pointSourceId = -1;
        this.qteVato = -1.0;
    }

    public int getPointSourceId() {
        return pointSourceId;
    }
//     public Centrifuge getCentrifuge() throws Exception {
//        Centrifuge vaovao = new Centrifuge();
//        vaovao.set(this.id);
//        ArrayList<Volamena> cpt = vaovao.select(null);
//        return cpt.get(0);
//    }

    public PointSource getPointSource() throws Exception {
        PointSource vaovao = new PointSource();
        vaovao.setId(this.pointSourceId);
        ArrayList<PointSource> cpt = vaovao.select(null);
        return cpt.get(0);
    }

//    public PointSource getPointSource() throws Exception {
//        return this.getPointSource().getPointSource();
//    }

    public void setPointSourceId(int pointSourceId) {
        this.pointSourceId = pointSourceId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQteVato() {
        return qteVato;
    }

    public void setQteVato(double qteVato) {
        this.qteVato = qteVato;
    }

}
