public class MedicalAppointment {
    private String appointmentID;
    private String date;
    private String appointmentMotive;
    private Doctor doctor;
    private Patient patient;

    public MedicalAppointment(String appointmentID, String date, String appointmentMotive, Doctor doctor, Patient patient) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.appointmentMotive = appointmentMotive;
        this.doctor = doctor;
        this.patient = patient;
    }
}
