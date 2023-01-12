//package view;
//
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.GridBagLayout;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTable;
//
//public class CardLayoutExemple {
//
//    public static void main(String[] args) throws Exception {
//
//        JFrame frame = new JFrame();
//        frame.setSize(1600, 400);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        // un panneau pour y mettre les différents composants à afficher, avec un cardlayout
//        CardLayout cardLayout = new CardLayout();
//        Board panel = new Board(1);
////        Couche1 p=new Couche1();
//        frame.getContentPane().add(panel); // on le met au centre du content pane de la fenêtre pour qu'il soit affiché
//    }
//
////    private static JPanel createPanel(String name, Color color) {
////        Board panel = new Board(); // le gridbaglayout c'est juste pour centrer le texte
////        panel.setBackground(color);
////        panel.add(new JLabel(name));
//////        panel.add(new JButton("BLABLAS" + name));
////        return panel;
////    }
//
////    public void paint(Graphics g) {
////        //super.paint(g);
////
//////        super;
////        int[] xPiste1 = {150, 280, 332, 451, 615, 855};
////        int[] yPiste1 = {150, 99, 110, 87, 160, 150};
////        g.drawPolyline(xPiste1, yPiste1, 6);
////
////        int[] xPiste2 = {150, 855};
////        int[] yPiste2 = {150, 150};
////        g.drawPolyline(xPiste2, yPiste2, 2);
////
////        g.drawRect(134, 115, 370, 300);
////        int[] xPiste3 = {150, 300, 460, 665, 855};
////        int[] yPiste3 = {150, 230, 175, 240, 150};
////
////    }
////
////    private static JButton creerBouton(
////            JPanel cardLayoutPanel, // le conteneur avec son layout cardlayout
////            CardLayout cardLayout, // la cardlayout
////            JPanel buttonPanel, // le panel des boutons pour pouvoir mettre le bouton dedans
////            String texteDuBouton, // le texte du bouton
////            String identifiantPanel, // il faut un identifiant de panel pour pouvoir le sélectionner dans le cardlayout
////            JPanel panel // le panneau à afficher quand on clique sur le bouton
////    ) {
////        // je créé le bouton
////        JButton button = new JButton(texteDuBouton);
////        // je mets le bouton dans le panneau des boutons
////        buttonPanel.add(button);
////
////        // j'ajoute le panel au cardLayoutPanel :
////        cardLayoutPanel.add(panel, identifiantPanel);
////
////        // ajoute un action listener pour afficher le panel quand on clique sur le bouton
////        button.addActionListener(e
////                -> cardLayout.show(cardLayoutPanel, identifiantPanel) // au clic, on demande d'afficher le composant qui correspond à l'identifiant
////        );
////
////        return button;
////
////    }
//
//}
