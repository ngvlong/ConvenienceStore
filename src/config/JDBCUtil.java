package config;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;


public class JDBCUtil {
    static String servername = "DESKTOP-0AIFNUD"; // Mỗi máy khác nhau
    static String servername1 = "DESKTOP-0AIFNUD\\MSSQLSERVER01"; // Mỗi máy khác nhau
    static String servername2 = "DESKTOP-0AIFNUD\\MSSQLSERVER02"; // Mỗi máy khác nhau
    static String servername3 = "DESKTOP-0AIFNUD\\MSSQLSERVER03"; // Mỗi máy khác nhau
    static int port = 1433;
    static String dbName="CuaHangTienLoi";
    static String username="sa";
    static String password = "";    
    
    public static Connection getOneConnection() throws SQLException  {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("");
        ds.setDatabaseName("CuaHangTienLoi");
        ds.setServerName("MSI");
        ds.setPortNumber(1433);
        Connection conn = ds.getConnection();
            System.out.println("Successfully");
        return conn;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}

