///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package view;
//
//import java.awt.Graphics;
//import java.awt.GridBagLayout;
//import java.awt.LayoutManager;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
///**
// *
// * @author dina
// */
//public class Board extends JPanel {
//
//    private double[] posX;
//    private double[] posY;
//
//    Couche1 couche1; //= new Couche1();
//    Couche2 couche2;// = new Couche2();
//    Couche3 couche3;// = new Couche3();
//    Couche4 couche4;
//
//    public Board() {
//    }
//
//    public Board(int id) throws Exception {
//
//        super();
//        couche1 = new Couche1(id);
//        couche2 = new Couche2(id);
//        couche3 = new Couche3(id);
//        couche4 = new Couche4(id);
////        this.add(new Couche1());
////        this.add(new Couche2());
////        this.add(new Couche3());
//
//    }
////    public Board(LayoutManager lay){
////        super(lay, true);
////}
//
//    public void paint(Graphics g) {
//        try {
//            //super.paint(g);
////        super;
////        int[] xPiste1 = {200, 200, 400, 400};
////        int[] yPiste1 = {300, 100, 300, 100};
////        for (int i = 0; i < yPiste1.length; i++) {
////            int j = yPiste1[i];
////            g.fillOval(xPiste1[i] - 150, yPiste1[i], 10, 10);
////            xPiste1[i] = xPiste1[i] - 150;
////        }
//            couche1.dessiner(g);
//            couche2.dessiner(g);
//            couche3.dessiner(g);
//            couche4.dessiner(g);
////
////            couche1.dessiner2(g);
////            couche2.dessiner2(g);
////            couche3.dessiner2(g);
////
//            
////        int[] xPiste2 = {150, 855};
////        int[] yPiste2 = {150, 150};
//            int[] xPiste3 = {50, 10, 620, 65, 185};
//            int[] yPiste3 = {12, 330, 5, 20, 10};
//
////        g.drawPolyline(xPiste3, yPiste3, 5);
//        } catch (Exception ex) {
//            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
