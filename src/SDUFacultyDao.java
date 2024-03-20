import java.sql.SQLException;
import java.util.List;

public interface SDUFacultyDao {

    public int add(SDUFaculty emp)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public SDUFaculty getFaculty(int id)
            throws SQLException;
    public List<SDUFaculty> getFaculties()
            throws SQLException;
    public void update(SDUFaculty emp)
            throws SQLException;
}
