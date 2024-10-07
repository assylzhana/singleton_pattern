import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Main {

    public static void main(String[] args)
            throws SQLException
    {
        String url = "jdbc:postgresql://localhost:5432/postgres"; // Update with your DB info
        String user = "postgres";
        String password = "postgres";

        // SQL query to create the table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS sdu_faculty (" +

                "name VARCHAR(255) NOT NULL, " +
                "specialities INT NOT NULL" +
                ");";

        // Try-with-resources to automatically close the connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // Execute the SQL query to create the table
            statement.execute(createTableSQL);
            System.out.println("Table 'sdu_faculty' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        SDUFaculty sduFaculty = new SDUFaculty();
        sduFaculty.setName("Engineering");
        sduFaculty.setSpecialities(5);
        SDUFacultyDaoImplementation sdu
                = new SDUFacultyDaoImplementation();

        sdu.add(sduFaculty);

        SDUFaculty sduFaculty2 = new SDUFaculty();
        sduFaculty2.setName("EDU");
        sduFaculty2.setSpecialities(4);
        sdu.add(sduFaculty2);

        SDUFaculty f = sdu.getFaculty(3);
        System.out.println(f.getId() + " "
                + f.getName() + " "
                + f.getSpecialities());

        List<SDUFaculty> ls = sdu.getFaculties();
        for (SDUFaculty all : ls) {
            System.out.println(all);
        }

        SDUFaculty upd = sdu.getFaculty(3);
        upd.setSpecialities(4);
        sdu.update(upd);

        sdu.delete(1);
    }
}
