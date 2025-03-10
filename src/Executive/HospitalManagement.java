package Executive;

import HMS.Patient;
import HMS.Doctor;
import HMS.AppointMent;
import java.sql.*;
import java.util.*;

public class HospitalManagement {
    private static final String URL = "jdbc:sqlserver://LUCKYSLAPYY:1434;databaseName=HospitalDB;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "Lucky";
    private static final String PASSWORD = "Hospital@123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("✅ Connected to SQL Server successfully!");

            do {
                System.out.println("\nHospital Management System");
                System.out.println("1. Add Patient");
                System.out.println("2. Add Doctor");
                System.out.println("3. Schedule Appointment");
                System.out.println("4. View Patients");
                System.out.println("5. View Doctors");
                System.out.println("6. View Appointments");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addPatient(scanner, connection);
                        break;
                    case 2:
                        addDoctor(scanner, connection);
                        break;
                    case 3:
                        scheduleAppointment(scanner, connection);
                        break;
                    case 4:
                        viewPatients(connection);
                        break;
                    case 5:
                        viewDoctors(connection);
                        break;
                    case 6:
                        viewAppointments(connection);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
        }
        scanner.close();
    }

    // Add Patient to Database
    private static void addPatient(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.next();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();

        String sql = "INSERT INTO Patients (Name, Gender, Age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, gender);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("✅ Patient added successfully!");
        }
    }

    // Add Doctor to Database
    private static void addDoctor(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.next();
        System.out.print("Enter Doctor Specialty: ");
        String specialty = scanner.next();

        String sql = "INSERT INTO Doctors (Name, Specialty) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, specialty);
            pstmt.executeUpdate();
            System.out.println("✅ Doctor added successfully!");
        }
    }

    // Schedule Appointment
    private static void scheduleAppointment(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.next();

        String sql = "INSERT INTO Appointments (PatientID, DoctorID, Date) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, patientId);
            pstmt.setInt(2, doctorId);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
            System.out.println("✅ Appointment scheduled successfully!");
        }
    }

    // View Patients
    private static void viewPatients(Connection connection) throws SQLException {
        String query = "SELECT * FROM Patients";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\nList of Patients:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("PatientID") +
                        ", Name: " + rs.getString("Name") +
                        ", Gender: " + rs.getString("Gender") +
                        ", Age: " + rs.getInt("Age"));
            }
        }
    }

    // View Doctors
    private static void viewDoctors(Connection connection) throws SQLException {
        String query = "SELECT * FROM Doctors";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\nList of Doctors:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("DoctorID") +
                        ", Name: " + rs.getString("Name") +
                        ", Specialty: " + rs.getString("Specialty"));
            }
        }
    }

    // View Appointments
    private static void viewAppointments(Connection connection) throws SQLException {
        String query = "SELECT a.AppointmentID, p.Name AS PatientName, d.Name AS DoctorName, a.Date " +
                "FROM Appointments a " +
                "JOIN Patients p ON a.PatientID = p.PatientID " +
                "JOIN Doctors d ON a.DoctorID = d.DoctorID";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\nList of Appointments:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("AppointmentID") +
                        ", Patient: " + rs.getString("PatientName") +
                        ", Doctor: " + rs.getString("DoctorName") +
                        ", Date: " + rs.getString("Date"));
            }
        }
    }
}
