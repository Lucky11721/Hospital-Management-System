package HMS;

public class Doctor {
    private static int idCounter = 1;
    private int Doctor_id;
    private String Doctor_name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.Doctor_id = idCounter++;
        this.Doctor_name = name;
        this.specialty = specialty;
    }

    public int getId() {
        return Doctor_id;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + Doctor_id + ", Name: " + Doctor_name + ", Specialty: " + specialty;
    }
}
