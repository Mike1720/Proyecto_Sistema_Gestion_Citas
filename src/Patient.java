public class Patient {
    private String name;
    private String medicalRecordNumber;

    public Patient(String name, String medicalRecordNumber) {
        this.name = name;
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public String toCSV() {
        return medicalRecordNumber + "," + name;
    }

    @Override
    public String toString() {
        return medicalRecordNumber + " - " + name;
    }
}
