public class SDUFaculty {
    int id;
    String name;
    int specialities;

    public SDUFaculty() {}

    public SDUFaculty(int id, String name, int specialities) {
        this.id = id;
        this.name= name;
        this.specialities =specialities;
    }

    public int getSpecialities() {
        return specialities;
    }

    public void setSpecialities(int specialities) {
        this.specialities = specialities;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
