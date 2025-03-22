interface AppointmentPage{
    void createAppointment(Doctor doctor, Patient patient, String disease);
    void showAppointmentDetails(Doctor doctor, Patient patient);
}
class Appointment implements AppointmentPage{
    private int appointmentID;
    private int patientID;
    private int doctorID;
    private String disease;
    
    public void setAppointmentID(int appointmentID){
        this.appointmentID = appointmentID;
    }
    public void setDoctorID(int doctorID){
        this.doctorID = doctorID;
    }
    public void setPatientID(int patientID){
        this.patientID = patientID;
    }
    public void setDisease(String disease){
        this.disease = disease;
    }
    
    public int getAppointmentID(){
        return appointmentID;
    }
    public int getDoctorID(){
        return doctorID;
    }
    public int getPatientID(){
        return patientID;
    }
    
    public String getDisease(){
        return disease;
    }
    @Override
    public void createAppointment(Doctor doctor, Patient patient, String disease){
        // Increment Appointment ID 
        Storage storage = new Storage();
        storage.setAppointmentsCount(storage.getAppointmentsCount() + 1); 
        
        // Storing All details to Appointment Class
        this.setAppointmentID(storage.getAppointmentsCount());
        this.setPatientID(patient.getPatientID());
        this.setDisease(disease);
        this.setDoctorID(doctor.getDoctorID());
    
        System.out.println("\n <<<<<<<<<<<<<<<<<<<<<<< Appointment Booked Successfully >> ");        
    }
    @Override
    public void showAppointmentDetails(Doctor doctor, Patient patient){
        
        System.out.println("\n Appointment ID - " + getAppointmentID());

        System.out.println(" Patient Name - " + patient.getName());
        System.out.println(" Patient ID - " + patient.getPatientID());
        System.out.println(" Patient Age - " + patient.getAge());       
        System.out.println(" Disease - " + getDisease() );

        System.out.println(" Doctor Name - " + doctor.getName());
        System.out.println(" Doctor ID - " + doctor.getDoctorID());         
        System.out.println(" Specialization - " + doctor.getSpecialization());
        System.out.println("");
    }
}