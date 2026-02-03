import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<MedicalAppointment> appointments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private int counterDoctors = 1;
    private int counterPatients = 1;
    private int counterAppointments = 1;

    public void menu() {
        int option;

        do {
            System.out.println("\n--- SISTEMA ---");
            System.out.println("1. Alta Doctor");
            System.out.println("2. Alta Paciente");
            System.out.println("3. Crear Cita");
            System.out.println("4. Mostrar Doctores");
            System.out.println("5. Mostrar Pacientes");
            System.out.println("6. Mostrar Citas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            option = readByte();

            switch (option) {
                case 1 -> instanceDoctor();
                case 2 -> instancePatient();
                case 3 -> createAppointment();
                case 4 -> showDoctors();
                case 5 -> showPatients();
                case 6 -> showAppointments();
                case 7 -> {
                    return;
                }

                default -> System.out.println("Opción inválida.");
            }

        } while (option != 7);
    }

    private void instanceDoctor() {

        String ID = generateDoctorID();

        String name = Validator.readText(scanner, "Nombre: ");
        String speciality = Validator.readText(scanner, "Especialidad: ");

        Doctor doctor = new Doctor(name, speciality, ID);

        doctors.add(doctor);
        FileUtil.saveData("db/doctores.csv", doctor.toCSV());

        System.out.println("Doctor registrado.");
    }

    private void instancePatient() {

        String ID = generatePatientID();

        String name = Validator.readText(scanner, "Nombre: ");

        Patient patient = new Patient(name, ID);

        patients.add(patient);
        FileUtil.saveData("db/pacientes.csv", patient.toCSV());

        System.out.println("Paciente registrado.");
    }

    private void createAppointment() {

        if (doctors.isEmpty() || patients.isEmpty()) {
            System.out.println("Debe existir al menos un doctor y un paciente.");
            return;
        }

        String ID = generateAppointmentID();
        System.out.println("ID Cita: " + ID);

        String date = Validator.readText(scanner, "Fecha y hora: ");
        String motive = Validator.readText(scanner, "Motivo: ");

        Doctor doctor;

        do {
            showDoctors();
            String doctorID = Validator.readText(scanner, "Ingrese el ID del Doctor: ");
            doctor = searchDoctor(doctorID);

            if (doctor == null) {
                System.out.println("Doctor no existe.");
            }
        } while (doctor == null);

        Patient patient;
        do {
            showPatients();
            String patientID = Validator.readText(scanner, "Ingrese el ID del Paciente: ");
            patient = searchPatient(patientID);

            if (patient == null) {
                System.out.println("Paciente no existe.");
            }
        } while (patient == null);

        MedicalAppointment appointment = new MedicalAppointment(ID, date, motive, doctor, patient);

        appointments.add(appointment);
        FileUtil.saveData("db/citas.csv", appointment.toCSV());

        System.out.println("Cita creada.");
    }

    private void showDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No hay doctores registrados.");
            return;
        }
        System.out.println("\n--- DOCTORES ---");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private void showPatients() {
        if (patients.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        System.out.println("\n--- PACIENTES ---");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private void showAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        System.out.println("\n--- CITAS MÉDICAS ---");
        for (MedicalAppointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private Doctor searchDoctor(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id))
                return doctor;
        }
        return null;
    }

    private Patient searchPatient(String id) {
        for (Patient patient : patients) {
            if (patient.getMedicalRecordNumber().equals(id))
                return patient;
        }
        return null;
    }

    private String generateDoctorID() {
        return String.format("DOC-%03d", counterDoctors++);
    }

    private String generatePatientID() {
        return String.format("PAC-%03d", counterPatients++);
    }

    private String generateAppointmentID() {
        return String.format("CIT-%03d", counterAppointments++);
    }

    private byte readByte() {
        while (true) {
            try {
                System.out.print("Opción: ");
                return Byte.parseByte(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }

    }
}
