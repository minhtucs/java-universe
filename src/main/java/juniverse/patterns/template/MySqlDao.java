package juniverse.patterns.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tunm2
 */
public class MySqlDao {

    void query(String sql, Object[] params) throws SQLException {
        Connection conn = DriverManager.getConnection("url", "user", "password");
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i, params[i]);
        }
        ResultSet resultSet = stmt.executeQuery();
        conn.close();
    }
    
}
