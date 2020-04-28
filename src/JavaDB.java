import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;

public class JavaDB {

    public static void main(String[] args) {
    String url, user, pass;
    url = "jdbc:postgresql://localhost:1433" + "databaseName = web1";
    user = "postgres";
    pass = "postgres";
    Connection con = null;
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);
        System.out.println(con.isClosed());
        String login = JOptionPane.showInputDialog("INforme o login: ") ;
        String senha = JOptionPane.showInputDialog("INforme a senha: ") ;

            /*String sql = "select * from usuario where login=? and senha=?" ;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, login);
            ps.setObject(2, senha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }
            */
        con.setAutoCommit(false);
        String sqlInsert = "insert into usuario (login, senha, nome) values(?,?,?)";
        PreparedStatement psInsert = con.prepareStatement(sqlInsert);
        psInsert.setObject(1, "maria2");
        psInsert.setObject(2, "123456");
        psInsert.setObject(3, "Maria2");
        psInsert.executeUpdate();
        psInsert.close();
        String sql = "select * from usuario" ;

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("nome"));
        }
        rs.close();
        ps.close();
        con.commit();

    } catch (Exception ex) {
        try {
            con.rollback();
        } catch (SQLException ex1) {
            Logger.getLogger(JavaDB.class.getName()).log(Level.SEVERE, null, ex1);
        }
        Logger.getLogger(JavaDB.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
//        try {
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(JavaDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}

}
