import java.util.HashMap;
interface DoctorPage{
    boolean ifAlreadyHaveAppointment(int patientID);
    void showDoctorDetails();
    void showAppointmentsList();
}
class Doctor implements DoctorPage{
    private String name;
    private String specialization;
    private int doctorID;
    
    // Key -> PatientID ,  Value -> AppointmentClass
    private  HashMap<Integer, Appointment> appointments = new HashMap<>();
    
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

    public int getDoctorID(){
        return doctorID;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public void putAppointmentDetails(int patientID, Appointment appointment){
        appointments.put(patientID, appointment);
    }
    public Appointment getAppointmentDetails(int patientID){
        return appointments.get(patientID);
    }
    public int getSizeOfAppointmentsList(){
        return appointments.size();
    }
    @Override
    public boolean ifAlreadyHaveAppointment(int patientID){
        return appointments.containsKey(patientID);
    }
    @Override
    public void showDoctorDetails(){
        System.out.println(" Doctor name - " + this.name);
        System.out.println(" Doctor ID - " + this.doctorID);
        System.out.println(" Specialization - " + this.specialization);
        System.out.println(" Appointments count - " + this.appointments.size());
        System.out.println("");
    }
    @Override
    public void showAppointmentsList()
    {
        Storage storage = new Storage();
        System.out.print("Doctor ");
        if (getSizeOfAppointmentsList() == 0) {            // Size of the Appointments details List
            System.out.print(getName()+ " Have ");
            System.out.println("\n0 Appointments !");
            return ;
        }
        System.out.println(  name + " Have " + appointments.size() + " Appointments..");
        System.out.println("Here's Appointments List ->");

        for(Appointment appointment: appointments.values()){
            Patient patient = (storage.getPatientDetails( appointment.getPatientID()));
            System.out.println(" Appointment ID : " + appointment.getAppointmentID());
            System.out.println(" Patient name : " + patient.getName());
            System.out.println(" Patient ID : " + patient.getPatientID());
            System.out.println(" Patient Age: " + patient.getAge());
            System.out.println(" Disease : " + appointment.getDisease());
            System.out.println("");
        }
    }

}