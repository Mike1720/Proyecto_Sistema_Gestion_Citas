public class Doctor {
    private String name;
    private String speciality;
    private String ID;

    public Doctor(String name, String speciality, String ID) {
        this.name = name;
        this.speciality = speciality;
        this.ID = ID;
    }
    
    public String getId() {
        return ID;
    }

    public String toCSV() {
        return ID + "," + name + "," + speciality;
    }

    public String toString() {
        return ID + " - " + name + " (" + speciality + ")";
    }
}
