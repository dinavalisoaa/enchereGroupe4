///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package view;
//
//import DAObject.Connexion;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.GradientPaint;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.LayoutManager;
//import java.awt.Rectangle;
//import java.sql.Connection;
//import java.util.ArrayList;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import model.PointSource;
//import static view.Couche3.suffle;
//
///**
// *
// * @author dina
// */
//public class Couche1 {
//    
//    int id;
//    
//    public Couche1() {
//    }
//    
//    public Couche1(int idd) throws Exception {
////        super();
//        this.id = idd;
//        
//    }
////    
////public static void main( String args[] ) {
////            JFrame frame = new JFrame ( "Bevel Arrows" );
////
////                frame.add ( new JPanel() {
////                    public void paintComponent ( Graphics g ) {
////                       drawArrowLine((Graphics2D) g, 100, 100, 700, 100, 14, 7);
////                        //x1, y1, width, height
////                        g.drawRect(10, 10, 500, 600);
////                        g.setColor(Color.red);
////                        //On le dessine aux coordonnées souhaitées
////                        g.fillOval(700, 100, 50, 50);
////
////                    }
////                }
////                , BorderLayout.CENTER );
////
////                frame.setSize ( 800, 400 );
////                frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
////                frame.setVisible ( true );
////
////    }
//
//    public static void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
//        int dx = x2 - x1, dy = y2 - y1;
//        double D = Math.sqrt(dx * dx + dy * dy);
//        double xm = D - d, xn = xm, ym = h, yn = -h, x;
//        double sin = dy / D, cos = dx / D;
//        
//        x = xm * cos - ym * sin + x1;
//        ym = xm * sin + ym * cos + y1;
//        xm = x;
//        
//        x = xn * cos - yn * sin + x1;
//        yn = xn * sin + yn * cos + y1;
//        xn = x;
//        
//        int[] xpoints = {x2, (int) xm, (int) xn};
//        int[] ypoints = {y2, (int) ym, (int) yn};
//        
//        g.drawLine(x1, y1, x2, y2);
//        g.fillPolygon(xpoints, ypoints, 3);
//    }
//    
//    public static PointSource[] TriParRapportEfficacite(Object[] lp) throws Exception {
////        PointSource[] lp = this.getPointSources();
//        if (lp != null) {
//            int i = 0;
//            while (i < lp.length) {
//                PointSource p = (PointSource) lp[i];
//                int j = i;
//                while (j > 0 && ((PointSource) lp[j - 1]).getEfficaciteJournalier() < p.getEfficaciteJournalier()) {
//                    lp[j] = lp[j - 1];
//                    j--;
//                }
//                lp[j] = p;
//                i++;
//            }
//        }
//        PointSource[] lps = new PointSource[lp.length];
//        
//        for (int i = 0; i < lp.length; i++) {
//            PointSource object = (PointSource) lp[i];
//            lps[i] = object;
//        }
//        return lps;
//    }
//    
//    public static PointSource[] sansTrie(Object[] lp) throws Exception {
////        PointSource[] lp = this.getPointSources();
//
//        PointSource[] lps = new PointSource[lp.length];
//        
//        for (int i = 0; i < lp.length; i++) {
//            PointSource object = (PointSource) lp[i];
//            lps[i] = object;
//        }
//        return lps;
//    }
//    
//    public static PointSource[] TriParRatio(Object[] lp) throws Exception {
////        PointSource[] lp = this.getPointSources();
//        if (lp != null) {
//            int i = 0;
//            while (i < lp.length) {
//                PointSource p = (PointSource) lp[i];
//                int j = i;
//                while (j > 0 && ((PointSource) lp[j - 1]).ratio() < p.ratio()) {
//                    lp[j] = lp[j - 1];
//                    j--;
//                }
//                lp[j] = p;
//                i++;
//            }
//        }
//        PointSource[] lps = new PointSource[lp.length];
//        
//        for (int i = 0; i < lp.length; i++) {
//            PointSource object = (PointSource) lp[i];
//            lps[i] = object;
//        }
//        return lps;
//    }
//    
//    public static PointSource[] TriParDure(Object[] lp) throws Exception {
////        PointSource[] lp = this.getPointSources();
//        if (lp != null) {
//            int i = 0;
//            while (i < lp.length) {
//                PointSource p = (PointSource) lp[i];
//                int j = i;
//                while (j > 0 && ((PointSource) lp[j - 1]).getDurete() < p.getDurete()) {
//                    lp[j] = lp[j - 1];
//                    j--;
//                }
//                lp[j] = p;
//                i++;
//            }
//        }
//        PointSource[] lps = new PointSource[lp.length];
//        
//        for (int i = 0; i < lp.length; i++) {
//            PointSource object = (PointSource) lp[i];
//            lps[i] = object;
//        }
//        return lps;
//    }
//
//    public static PointSource[] TriMontant(Object[] lp) throws Exception {
////        PointSource[] lp = this.getPointSources();
//        if (lp != null) {
//            int i = 0;
//            while (i < lp.length) {
//                PointSource p = (PointSource) lp[i];
//                int j = i;
//                while (j > 0 && ((PointSource) lp[j - 1]).getBene() < p.getBene()) {
//                    lp[j] = lp[j - 1];
//                    j--;
//                }
//                lp[j] = p;
//                i++;
//            }
//        }
//        PointSource[] lps = new PointSource[lp.length];
//        
//        for (int i = 0; i < lp.length; i++) {
//            PointSource object = (PointSource) lp[i];
//            lps[i] = object;
//        }
//        return lps;
//    }
//
//    public static PointSource[] TriFotona(Object[] lp) throws Exception {
////        PointSource[] lp = this.getPointSources();
//        if (lp != null) {
//            int i = 0;
//            while (i < lp.length) {
//                PointSource p = (PointSource) lp[i];
//                int j = i;
//                while (j > 0 && ((PointSource) lp[j - 1]).getDurer() < p.getDurer()) {
//                    lp[j] = lp[j - 1];
//                    j--;
//                }
//                lp[j] = p;
//                i++;
//            }
//        }
//        PointSource[] lps = new PointSource[lp.length];
//        
//        for (int i = 0; i < lp.length; i++) {
//            PointSource object = (PointSource) lp[i];
//            lps[i] = object;
//        }
//        return lps;
//    }
//    
//    public void dessiner(Graphics g) throws Exception {
//        int[] xPiste1 = new int[]{};
//        int[] yPiste1 = new int[]{};
//        PointSource pts = new PointSource();
//        pts.setMiniereId(this.id);
//        Connection con = Connexion.getConn();
//        ArrayList<PointSource> li = pts.select(con);
//        PointSource[] value = sansTrie(li.toArray());
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        g.drawString("Courche efficacite", 0, 50);
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            xPiste1[i] = (int) val.getPosX();
//            yPiste1[i] = (int) val.getPosY();
//            
//            g.fillOval(xPiste1[i] - 150, yPiste1[i], 10, 10);
//            xPiste1[i] = xPiste1[i] - 150;
//        }
//        con.close();
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        int cpt = 0;
//        value = Couche1.TriParRapportEfficacite(value);
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            xPiste1[cpt] = (int) val.getPosX();
//            yPiste1[cpt] = (int) val.getPosY();
//            g.drawString(val.getNom()+" "+Double.toString(val.getEfficaciteJournalier()) + "g/j", xPiste1[i] - 150, yPiste1[i]-15);
//            xPiste1[cpt] = xPiste1[cpt] - 150;
//            cpt++;
//        }
//        int index = value.length;
//        
////        g.drawRect(10, 10, 500, 600);
////        g.setColor(Color.red);
////        g.fillOval(700, 100, 50/, 50);
////        g.setColor(Color.LIGHT_GRAY);
//        Graphics2D g2d=(Graphics2D)g;
//        g2d.setPaint(new GradientPaint(xPiste1[1], yPiste1[1],Color.GRAY,xPiste1[0], yPiste1[0],Color.BLACK));
////         xPiste1=suffle(xPiste1);
//
//drawArrowLine(g2d, xPiste1[1], yPiste1[1], xPiste1[0], yPiste1[0], 14, 7);
//g.setColor(Color.BLACK);
////        g2d.drawPolyline(xPiste1, yPiste1, 4);
////        g.setColor(new Color());
////Color col=new C
//        g.drawRect(0, 50, 280, 300);
////        g.drawRect(280, 50, 280, 300);
////        g.drawRect(560, 50, 280, 300);
//    }
//      public void dessiner2(Graphics g) throws Exception {
//        int[] xPiste1 = new int[]{};
//        int[] yPiste1 = new int[]{};
//        PointSource pts = new PointSource();
//        pts.setMiniereId(this.id);
//        Connection con = Connexion.getConn();
//        ArrayList<PointSource> li = pts.select(con);
//        PointSource[] value = sansTrie(li.toArray());
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        g.drawString("Courche efficacite", 0, 50);
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            xPiste1[i] = (int) val.getPosX()+840;
//            yPiste1[i] = (int) val.getPosY();
//            
//            g.fillOval(xPiste1[i] - 150, yPiste1[i], 10, 10);
//            xPiste1[i] = xPiste1[i] - 150;
//        }
//        con.close();
//        xPiste1 = new int[li.size()];
//        yPiste1 = new int[li.size()];
//        int cpt = 0;
//        value = Couche1.TriParRapportEfficacite(value);
//        for (int i = 0; i < value.length; i++) {
//            PointSource val = value[i];
//            xPiste1[cpt] = (int) val.getPosX()+840;
//            yPiste1[cpt] = (int) val.getPosY();
//            xPiste1[cpt] = xPiste1[cpt] - 150;
//            cpt++;
//        }
//       
//        g.drawString("Efficite"+Double.toString(value[0].getEfficaciteJournalier()) + "g/j", 0, 250);
//        g.drawString("Durete"+Double.toString(value[0].getDurete()) + "t/h",0, 300);
//        g.drawString("Propotion"+(Double.toString(value[0].ratio())) + "g/t", 0,350);
//        g.drawString("Montant"+(Double.toString(value[0].getBene())) + "Ar/j", 0, 400);
//        
//        int index = value.length;
//        
//          
////        g.drawRect(10, 10, 500, 600);
////        g.setColor(Color.red);
////        g.fillOval(700, 100, 50/, 50);
////        g.setColor(Color.LIGHT_GRAY);
//        Graphics2D g2d=(Graphics2D)g;
//        g2d.setPaint(new GradientPaint(xPiste1[1], yPiste1[1],Color.GRAY,xPiste1[0], yPiste1[0],Color.BLACK));
////         xPiste1=suffle(xPiste1);
//
//drawArrowLine(g2d, xPiste1[1], yPiste1[1], xPiste1[0], yPiste1[0], 14, 7);
//g.setColor(Color.BLACK);
////        g2d.drawPolyline(xPiste1, yPiste1, 4);
////        g.setColor(new Color());
////Color col=new C
//        g.drawRect(0, 50, 280, 300);
////        g.drawRect(280, 50, 280, 300);
////        g.drawRect(560, 50, 280, 300);
//    }
//    
//    public void paint(Graphics g) {
//        //super.paint(g);
////        super;
//        int[] xPiste1 = {150, 280, 332, 451, 615, 855};
//        int[] yPiste1 = {150, 99, 110, 87, 160, 150};
////        g.drawPolyline(xPiste1, yPiste1, 6);
//        int[] xPiste2 = {150, 855};
//        int[] yPiste2 = {150, 150};
////        g.drawPolyline(xPiste2, yPiste2, 2);
//        g.drawRect(0, 50, 280, 300);
////        int[] xPiste3 = {150, 300, 460, 665, 855};
////        int[] yPiste3 = {150, 230, 175, 240, 150};
//
//    }
//    
//}
