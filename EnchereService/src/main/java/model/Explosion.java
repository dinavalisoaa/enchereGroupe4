/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BddObject.ObjectBDD;
import BddObject.InfoDAO;
import java.util.ArrayList;

/**
 *
 * @author dina
 */

/**
 *
 * @author dina
 */
@InfoDAO(table = "Explosion")
public class Explosion extends ObjectBDD {

    int id = -1;
    int pointSourceId = -1;
    double qteVato = -1.0;
    String daty;

    public int getId() {
        return id;
    }
    

//    public Volamena[] getVolamena() throws Exception {
//        Volamena vao = new Volamena();
//        vao.setExplosionId(this.id);
//        ArrayList list = vao.select(null);
//        ArrayList lis = new Fitotona().select(null);
//        Fitotona[] oo = new Fitotona[lis.size()];
//        for (int i = 0; i < oo.length; i++) {
//            oo[i] = (Fitotona) lis.get(i);
//        }
//        return oo;
//    }

//    public Fitotona[] getFitotonas() throws Exception {
//        Fitotona vao = new Fitotona();
//        vao.setExplosionId(this.id);
//        ArrayList list = vao.select(null);
//        ArrayList lis = new Fitotona().select(null);
//        Fitotona[] oo = new Fitotona[lis.size()];
//        for (int i = 0; i < oo.length; i++) {
//            oo[i] = (Fitotona) lis.get(i);
//        }
//        return oo;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public static Explosion[] explosions() throws Exception {
        ArrayList lis = new Explosion().select(null);
        Explosion[] oo = new Explosion[lis.size()];
        for (int i = 0; i < oo.length; i++) {
            oo[i] = (Explosion) lis.get(i);
        }
        return oo;
    }

    public PointSource getPointSource() throws Exception {
        PointSource vaovao = new PointSource();
        vaovao.setId(this.pointSourceId);
        ArrayList<PointSource> cpt = vaovao.select(null);
        return cpt.get(0);
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

    public String getDaty() {
        return daty;
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }

}
