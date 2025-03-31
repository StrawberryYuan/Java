package hx.util;

import java.sql.*;

public class JdbcUtil {
  private static final String URL = "jdbc:mysql://localhost:3306/OnlineExamDB?useSSL=false&serverTimezone=UTC";
  private static final String USER = "root";
  private static final String PASSWORD = "ZCbm147258";

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void close(Connection conn, Statement stmt, ResultSet rs) {
    try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
    try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
    try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
  }
}
