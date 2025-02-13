package HMS;

import javax.print.Doc;

public class AppointMent {
   private Patient patient;
    private Doctor doctor;
    private String Date;

    public AppointMent(Patient patient , Doctor doctor , String Date){
        this.patient = patient;
        this.doctor = doctor;
        this.Date = Date;
    }
    public String toString() {
        return "Appointment: [Patient: " + patient + ", Doctor: " + doctor + ", Date: " + Date + "]";
    }
}
