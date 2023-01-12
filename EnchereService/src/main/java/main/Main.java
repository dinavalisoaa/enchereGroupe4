///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package main;
//import java.awt.*;
//import javax.swing.*;
//import java.awt.geom.AffineTransform;
//
//public class Main extends JPanel {
//
//
//
//public static void main( String args[] ) {
//            JFrame frame = new JFrame ( "Bevel Arrows" );
//
//                frame.add ( new JPanel() {
//                    public void paintComponent ( Graphics g ) {
//                       drawArrowLine((Graphics2D) g, 100, 100, 700, 100, 14, 7);
//                        //x1, y1, width, height
//                        g.drawRect(10, 10, 500, 600);
//                        g.setColor(Color.red);
//                        //On le dessine aux coordonnées souhaitées
//                        g.fillOval(700, 100, 50, 50);
//
//                    }
//                }
//                , BorderLayout.CENTER );
//
//                frame.setSize ( 800, 400 );
//                frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
//                frame.setVisible ( true );
//
//    }
//
//private static void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
//    int dx = x2 - x1, dy = y2 - y1;
//    double D = Math.sqrt(dx*dx + dy*dy);
//    double xm = D - d, xn = xm, ym = h, yn = -h, x;
//    double sin = dy / D, cos = dx / D;
//
//    x = xm*cos - ym*sin + x1;
//    ym = xm*sin + ym*cos + y1;
//    xm = x;
//
//    x = xn*cos - yn*sin + x1;
//    yn = xn*sin + yn*cos + y1;
//    xn = x;
//
//    int[] xpoints = {x2, (int) xm, (int) xn};
//    int[] ypoints = {y2, (int) ym, (int) yn};
//
//    g.drawLine(x1, y1, x2, y2);
//    g.fillPolygon(xpoints, ypoints, 3);
//}
//}
//
