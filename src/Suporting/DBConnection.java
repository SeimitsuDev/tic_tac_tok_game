package Suporting;

import java.sql.*;


public class DBConnection {
    String query;
    String pass;
    public DBConnection(String q){
        query = q;
    }

    public String DBMain() throws SQLException, ClassNotFoundException{


        query = query.trim().toLowerCase();
        System.out.println(query+"In DBConnection...");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IPB_First", "root", "root1234");

        PreparedStatement ps = con.prepareStatement("select * from users where user_email = ?");
        ps.setString(1, query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        this.pass = rs.getString("user_pass");
        con.close();


        return this.pass;
    }
}
