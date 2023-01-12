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
@InfoDAO(table = "Volamena")
public class Volamena extends ObjectBDD {

    private int id;
   int centrifugeId=-1;
    private int pointSourceId=-1;
    private double qteVolamena;
    private String daty;
    @Ignore
    private Centrifuge centrifuge;
    public Volamena() {
        this.id = -1;
        this.centrifugeId = -1;
        this.qteVolamena = -1.0;
    }
//    public 
    public Centrifuge getCentrifuge() throws Exception {
        Centrifuge vaovao = new Centrifuge();
        vaovao.setId(this.centrifugeId);
        ArrayList<Centrifuge> cpt = vaovao.select(null);
        return cpt.get(0);
    }
    
//
//    public Fitotona getFitotona() throws Exception {
//        return this.getCentrifuge().getFitotona();
//    }
//
//    public Explosion getExplosion() throws Exception {
//        return this.getCentrifuge().getFitotona().getExplosion();
//    }

//    public PointSource getPointSource() throws Exception {
//        return this.getExplosion().getPointSource();
//    }

    public int getCentrifugeId() {
        return centrifugeId;
    }

    public void setCentrifugeId(int centrifugeId) {
        this.centrifugeId = centrifugeId;
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

    public void setPointSourceId(int centrifugeIdId) {
        this.pointSourceId = centrifugeIdId;
    }

    public double getQteVolamena() {
        return qteVolamena;
    }

    public void setQteVolamena(double qteVolamena) {
        this.qteVolamena = qteVolamena;
    }

    public String getDaty() {
        return daty;
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }

}
