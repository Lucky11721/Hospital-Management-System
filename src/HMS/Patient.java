package HMS;

public class Patient {
    private static int count  = 1;
    private int Patient_id;
    private String Name;
    private String Gender;
    private int age;

    public Patient(String Name , String Gender , int age){
        this.Patient_id = count++;
        this.Name = Name;
        this.Gender = Gender;
        this.age = age;
    }
//    public void print(){
//        System.out.println("id " + Patient_id);
//        System.out.println("Name " + Name);
//        System.out.println("gender " +Gender);
//        System.out.println("Age " +age);
//    }
    public int getId(){
        return Patient_id;
    }

    public String toString() {
        return "Patient ID : " + Patient_id + " Patient Name : "+Name + " Gender : " + Gender + " Age + " + age;
    }


}
