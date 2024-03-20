
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SDUFacultyDaoImplementation implements SDUFacultyDao {

    static Connection con
            = DatabaseConnection.getConnection();

    @Override
    public int add(SDUFaculty faculty)
            throws SQLException
    {

        String query
                = "insert into sdu_faculty(name, "
                + "specialities) VALUES (?, ?)";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, faculty.getName());
        ps.setInt(2, faculty.getSpecialities() );
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id)
            throws SQLException
    {
        String query
                = "delete from sdu_faculty where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public SDUFaculty getFaculty(int id)
            throws SQLException
    {

        String query
                = "select * from sdu_faculty where id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setInt(1, id);
        SDUFaculty faculty = new SDUFaculty();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            faculty.setId(rs.getInt("id"));
            faculty.setName(rs.getString("name"));
            faculty.setSpecialities(rs.getInt("specialities"));
        }

        if (check == true) {
            return faculty;
        }
        else
            return null;
    }

    @Override
    public List<SDUFaculty> getFaculties()
            throws SQLException
    {
        String query = "select * from sdu_faculty";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<SDUFaculty> ls = new ArrayList();

        while (rs.next()) {
            SDUFaculty faculty = new SDUFaculty();
            faculty.setId(rs.getInt("id"));
            faculty.setName(rs.getString("name"));
            faculty.setSpecialities(rs.getInt("specialities"));
            ls.add(faculty);
        }
        return ls;
    }

    @Override
    public void update(SDUFaculty faculty)
            throws SQLException
    {

        String query
                = "update sdu_faculty set name=?, "
                + " specialities= ? where id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, faculty.getName());
        ps.setInt(2, faculty.getSpecialities());
        ps.setInt(3, faculty.getId());
        ps.executeUpdate();
    }
}
