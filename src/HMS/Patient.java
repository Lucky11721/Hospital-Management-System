package HMS;

public class Patient {
    private int id;
    private String name;
    private String gender;
    private int age;

    public Patient(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Gender: " + gender + ", Age: " + age;
    }
}
