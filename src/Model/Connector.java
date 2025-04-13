
package Model;

import java.sql.*;

public class Connector {
    private Connection con;
    
    public Connector() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlpkbida", "root", "");
    }
    
    public ResultSet getData(String tenBang) throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        String sql = "select * from " + tenBang;
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getDataBySQL(String sql) throws SQLException{
        ResultSet rs = null;
        Statement st = con.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public void updateQuery(String sql) throws SQLException{
        Statement st = con.createStatement();
        st.executeUpdate(sql);
    }
    
    
    
    public void Close(){
        if(this.con != null)
            this.con = null;
    }
}
