import java.util.HashMap;
interface DoctorPage{
    boolean isAlreadyHaveAppointment(int patientID);
    void showDoctorDetails();
    void showAppointmentsList();
}
class Doctor implements DoctorPage{
    private String name;
    private String specialization;
    private int doctorID;
    // private int appointmentsCount;
    // Key -> PatientID ,  Value -> AppointmentClass
    private HashMap<Integer, Appointment> appointments = new HashMap<>();
    public Doctor(String name, String specialization){
        this.name = name;
        this.specialization = specialization;
    }
    public void setDoctorID(int doctorID){
        this.doctorID = doctorID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    // public void setAppoint( ){
    //     appointmentsCount += 1;
    // }
    
    public void putAppointmentToMap(int patientID, Appointment appointment){
        appointments.put(patientID, appointment);
    }
    public Appointment getAppointmentFromMap(int patientID){
        return appointments.get(patientID);
    }
    public boolean isAlreadyHaveAppointment(int patientID){
        return appointments.containsKey(patientID);
    }

    public int getAppointmentsCount(){
        return appointments.size();
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public int getDoctorID(){
        return doctorID;
    }
    
    public void showDoctorDetails(){
        System.out.println(" Doctor name - " + this.name);
        System.out.println(" Doctor ID - " + this.doctorID);
        System.out.println(" Specialization - " + this.specialization);
        System.out.println(" Appointments count - " + this.appointments.size());
        System.out.println("");
    }
    public void showAppointmentsList(){
        Main m = new Main();
        if (appointments.isEmpty()) {
            System.out.print(getName()+ " Have ");
            System.out.println("\n0 Appointments !");
            return ;
        }
        System.out.println("\nAppointments details for DoctorID - " + getDoctorID());
        for(Appointment appointment: appointments.values()){
            Patient patient = (m.patients.get( appointment.getPatientID()));
            System.out.println("Appointment ID : " + appointment.getAppointmentID());
            System.out.println("Patient ID : " + appointment.getPatientID());
            System.out.println("Patient name : " + patient.getName());
            System.out.println("Disease : " + appointment.getDisease());
            System.out.println("");
        }
    }

}