import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/sdu_faculty";
            String user = "postgres";
            String pass = "asylka225";
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
