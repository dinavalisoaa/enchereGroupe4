package BddObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Connexion {
    public static Connection getConn() throws Exception {
         Connection connectionSQL=null;
         try {
            Class.forName("org.postgresql.Driver");
            connectionSQL = DriverManager.getConnection("jdbc:postgresql://localhost:5432/enchere","postgres","root");
            System.out.println("Driver O.K");
        } catch (Exception e) {
            System.out.println("tsia");
            System.out.print(e);
            e.printStackTrace();
        }
        return connectionSQL;
    }
//    public static Connection getConnection()throws Exception
//    {
//         String connectionUrl
//                = "jdbc:sqlserver://DESKTOP-S2H695T;database=volamena;"
//                + "user=sa;password=root;"
//                + "; trustServerCertificate=true;";
//         
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-S2H695T\\Dina;databaseName=volamena;integratedSecurity=false;Trusted Connection=true","sa","root");
//        Connection con = DriverManager.getConnection(connectionUrl);
//         PreparedStatement ps = con.prepareStatement("SELECT * FROM miniere");
//            /*PreparedStatement ps= connection.prepareStatement("INSERT INTO Personne VALUES (CONCAT('Personne_',NEXT VALUE FOR s_Personne),'AndryBe','Soabe','Need2','it')");
//            ps.execute();*/
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
////                System.err.println(rs.getString("idPersonne"));
//                System.err.println(rs.getString("nom"));
////                System.err.println(rs.getString("Prenom"));
//            }
//return con;
//    }

}
