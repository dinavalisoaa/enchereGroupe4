/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAObject.Connexion;
import java.sql.Connection;

/**
 *
 * @author dina
 */
public class Calcul {
    PointSource lavaka;
    double ratio;
    double durete;
    double efficacite;
    double efficaciteJour;
    double prixVolamena;
    double gainJour;
    
public Calcul(){}
    public Calcul(PointSource sor)throws Exception{
        this.lavaka=sor;
        Connection on=Connexion.getConn();
        this.ratio = this.lavaka.ratio(on);
        this.durete = this.lavaka.getDureteHoraire(on);
        this.prixVolamena = this.lavaka.getVidinaVolamena();
       
//        this.efficaciteJour=this.efficacite*8;
//        this.gainJour=this.efficacite*8*this.prixVolamena;
        on.close();
    }

    
    public PointSource getLavaka() {
        return lavaka;
    }

    public void setLavaka(PointSource lavaka) {
        this.lavaka = lavaka;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getDurete() {
        return durete;
    }

    public void setDurete(double durete) {
        this.durete = durete;
    }

    public double getGainJour() {
        return this.getEfficacite()*this.prixVolamena;
    }

    public void setGainJour(double gainJour) {
        this.gainJour = gainJour;
    }

    public double getEfficacite() {
        return  this.ratio*this.durete*8;
    }

    public void setEfficacite(double efficacite) {
        this.efficacite = efficacite;
    }

    public double getPrixVolamena() {
        return prixVolamena;
    }

    public double getEfficaciteJour() {
        return this.getEfficacite()*8;
    }

    public void setEfficaciteJour(double efficaciteJour) {
        this.efficaciteJour = efficaciteJour;
    }

    public void setPrixVolamena(double prixVolamena) {
        this.prixVolamena = prixVolamena;
    }
    
}
