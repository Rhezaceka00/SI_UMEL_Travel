import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
/**
 *
 * @author RHEZA
 */
public class Koneksi {
    private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Koneksi berhasil ler....");
        }catch(ClassNotFoundException ex){
            System.out.println("Gagal konek"+ex);
        }
        String url = "jdbc:mysql://localhost/umeltravel";
        try{
            koneksi = (Connection)DriverManager.getConnection(url,"root","");
        }catch(SQLException ex){
            System.out.println("Gagal konek db"+ex);
        }
        return koneksi;
    }
}
