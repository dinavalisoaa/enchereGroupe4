/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class Connexion {
    public static Connection getConnection()throws Exception
    {
         String connectionUrl
                = "jdbc:sqlserver://DESKTOP-S2H695T;database=volamena;"
                + "user=sa;password=root;"
                + "; trustServerCertificate=true;";
         
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-S2H695T\\Dina;databaseName=volamena;integratedSecurity=false;Trusted Connection=true","sa","root");
        Connection con = DriverManager.getConnection(connectionUrl);
         PreparedStatement ps = con.prepareStatement("SELECT * FROM miniere");
            /*PreparedStatement ps= connection.prepareStatement("INSERT INTO Personne VALUES (CONCAT('Personne_',NEXT VALUE FOR s_Personne),'AndryBe','Soabe','Need2','it')");
            ps.execute();*/
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                System.err.println(rs.getString("idPersonne"));
                System.err.println(rs.getString("nom"));
//                System.err.println(rs.getString("Prenom"));
            }
return con;
    }
     public static void main(String[] args) throws Exception {
        Connection con = Connexion.getConnection();
//        con.close();
    }

}
