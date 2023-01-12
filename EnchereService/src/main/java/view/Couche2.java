///*
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package view;
//
//import DAObject.Connexion;
//import java.awt.Color;
//import java.awt.GradientPaint;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.LayoutManager;
//import java.awt.List;
//import java.awt.Rectangle;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import javax.swing.JPanel;
//import javax.swing.plaf.ColorUIResource;
//import model.PointSource;
//import static view.Couche1.TriParRapportEfficacite;
//import static view.Couche1.drawArrowLine;
//
///**
// *
// * @author dina
// */
//public class Couche2 {
//
//   int id;
//    public Couche2(int idd) {
////        super();
//        this.id=idd;
//    }
//    public Couche2(){}
//    public static int[] suffle(int[] a) {
//        ArrayList lit = new ArrayList();
//        for (int i = 0; i < a.length; i++) {
//            int j = a[i];
//            lit.add(j);
//        }
//        a = new int[lit.size()];
//        Collections.shuffle(lit);
//        for (int i = 0; i < lit.size(); i++) {
//            a[i] = (int) lit.get(i);
//        }
//        return a;
//    }
//
//    public void dessiner(Graphics g) throws Exception {
//        int[] xPiste1 = new int[]{};
//        int[] yPiste1 = new int[]{};
//        PointSource pts = new PointSource();
//        pts.setMiniereId(this.id);
//        Connection con=Connexion.getConn();
//          g.drawString("Couche par durete",280,50);
//        ArrayList<PointSource> li = pts.select(con);
//        PointSource[] value = TriParRapportEfficacite(li.toArray());
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            xPiste1[i] = (int) val.getPosX()+280;
//            yPiste1[i] = (int) val.getPosY();
//            g.fillOval(xPiste1[i] - 150, yPiste1[i], 10, 10);
//            xPiste1[i] = xPiste1[i] - 150;
//        }
//        con.close();
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        int cpt = 0;
//        value=Couche1.TriParDure(value);
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            
//            xPiste1[cpt] = (int) val.getPosX()+280;
//            yPiste1[cpt] = (int) val.getPosY();
//                g.drawString(val.getNom()+" "+Double.toString(val.getDurete())+"t/h", xPiste1[i] - 150, yPiste1[i]-10);
//            xPiste1[cpt] = xPiste1[cpt] - 150;
//            cpt++;
//        }
//         Graphics2D g2d=(Graphics2D)g;
//        g2d.setPaint(new GradientPaint(xPiste1[1], yPiste1[1],Color.YELLOW,xPiste1[0], yPiste1[0],Color.RED));
////         xPiste1=suffle(xPiste1);
//
////        g.setColor(Color.CYAN);
//       drawArrowLine(g2d,xPiste1[1], yPiste1[1], xPiste1[0], yPiste1[0], 14, 7);
//       g.setColor(Color.BLACK);
//
////        g.drawRect(10, 10, 500, 600);
////        g.setColor(Color.red);
////        g.fillOval(700, 100, 50/, 50);
//        
////         xPiste1=suffle(xPiste1);
////        g.drawPolyline(xPiste1, yPiste1, 4);
////        g.drawRect(0, 50, 280, 300);
//         g.drawRect(280, 50, 280, 300);
////        g.drawRect(280, 50, 280, 300);
////        g.drawRect(560, 50, 280, 300);
//    
//
//}
//      public void dessiner2(Graphics g) throws Exception {
//        int[] xPiste1 = new int[]{};
//        int[] yPiste1 = new int[]{};
//        PointSource pts = new PointSource();
//        pts.setMiniereId(this.id);
//        Connection con=Connexion.getConn();
//          g.drawString("Couche par durete",280,50);
//        ArrayList<PointSource> li = pts.select(con);
//        PointSource[] value = TriParRapportEfficacite(li.toArray());
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            xPiste1[i] = (int) val.getPosX()+840;
//            yPiste1[i] = (int) val.getPosY();
//            g.fillOval(xPiste1[i] - 150, yPiste1[i], 10, 10);
//            xPiste1[i] = xPiste1[i] - 150;
//        }
//        con.close();
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        int cpt = 0;
//        value=Couche1.TriParDure(value);
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            xPiste1[cpt] = (int) val.getPosX()+840;
//            yPiste1[cpt] = (int) val.getPosY();
//             xPiste1[cpt] = xPiste1[cpt] - 150;
//            cpt++;
//        }
//        g.drawString("Efficite"+Double.toString(value[1].getEfficaciteJournalier()) + "g/j", 350, 250);
//        g.drawString("Durete"+Double.toString(value[1].getDurete()) + "t/h",350, 300);
//        g.drawString("Propotion"+(Double.toString(value[1].ratio())) + "t/g", 350,350);
//        g.drawString("Montant:"+(Double.toString(value[1].getBene())) + "Ar", 350, 400);
//        
////        g.drawString(Double.toString(value[0].getDurete())+"t/h", xPiste1[0] - 150, yPiste1[0]-10);
//       
//         Graphics2D g2d=(Graphics2D)g;
//        g2d.setPaint(new GradientPaint(xPiste1[1], yPiste1[1],Color.YELLOW,xPiste1[0], yPiste1[0],Color.RED));
////         xPiste1=suffle(xPiste1);
//
////        g.setColor(Color.CYAN);
//       drawArrowLine(g2d,xPiste1[1], yPiste1[1], xPiste1[0], yPiste1[0], 14, 7);
//       g.setColor(Color.BLACK);
//
////        g.drawRect(10, 10, 500, 600);
////        g.setColor(Color.red);
////        g.fillOval(700, 100, 50/, 50);
//        
////         xPiste1=suffle(xPiste1);
////        g.drawPolyline(xPiste1, yPiste1, 4);
////        g.drawRect(0, 50, 280, 300);
//         g.drawRect(280, 50, 280, 300);
////        g.drawRect(280, 50, 280, 300);
////        g.drawRect(560, 50, 280, 300);
//    }
//}