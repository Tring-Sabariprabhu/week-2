import java.util.ArrayList;
interface PatientPage{
    void showPatientDetails();
    void showBookedAppointmentsList();
}
class Patient implements PatientPage{
    private int patientID;
    private String name;
    private int age;
    // private String disease;
    // Key -> Appointment Class
    private ArrayList<Appointment> bookedAppointments = new ArrayList<>();
    
    public Patient(String name, int age){
        this.name = name;
        this.age = age;
        // this.disease = disease;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPatientID(int patientID){
        this.patientID = patientID;
    }
    public void putAppointmentToList( Appointment appointment){
        bookedAppointments.add(appointment);
    }
    public Appointment getAppointmentFromList(int doctorID){
        return bookedAppointments.get(doctorID);
    }
    // public String getDisease(){
    //     return disease;
    // }
    // public void setDisease(String disease){
    //     this.disease = disease;
    // }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getPatientID(){
        return patientID;
    }
    
    public int getBookedAppointmentsCount(){
        return bookedAppointments.size();
    }
    
   public void showPatientDetails(){
        System.out.println(" Patient name - " + this.name);
        System.out.println(" Patient ID - " + this.patientID);
        System.out.println(" Patient Age - " + this.age);
        System.out.println(" Your Booked Appointments count - " + this.getBookedAppointmentsCount());
        System.out.println("\n");
    }
    public void showBookedAppointmentsList(){
        Main m = new Main();
        if (bookedAppointments.isEmpty()) {
            System.out.println("\nNo Appointments found!");
            return ;
        }
        System.out.println("\nAppointments details for PatientID - " + getPatientID());
        for(Appointment appointment : bookedAppointments ){
            Doctor doctor = (m.doctors.get( appointment.getDoctorID()));
            System.out.println("Appointment ID : " + appointment.getAppointmentID());
            System.out.println("Doctor ID : " + appointment.getDoctorID());
            System.out.println("Doctor name : " + doctor.getName());
            System.out.println("Specialization : " +appointment.getSpecialization());
            System.out.println("Disease : " + appointment.getDisease());
            System.out.println("");

        }
    }
    
}