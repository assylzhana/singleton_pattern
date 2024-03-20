import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args)
            throws SQLException
    {

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
