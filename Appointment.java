interface AppointmentPage{
    void createAppointment(Doctor doctor, Patient patient, String disease);
    void showAppointmentDetails(Doctor doctor, Patient patient);
}
class Appointment{
    private int appointmentID;
    private int patientID;
    private int doctorID;
    private String patientName;
    private String doctorName;
    private String disease;
    private String specialization;
    public void setAppointmentID(int appointmentID){
        this.appointmentID = appointmentID;
    }
    public void setDoctorID(int doctorID){
        this.doctorID = doctorID;
    }
    public void setPatientID(int patientID){
        this.patientID = patientID;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
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
    public String getSpecialization(){
        return specialization;
    }
    public String getDisease(){
        return disease;
    }
    public void createAppointment(Doctor doctor, Patient patient, String disease){
        // Increment Appointment ID 
        Main m = new Main();
        m.appointmentsCount++;
        
        // Storing All details to Appointment Class
        this.setAppointmentID(m.appointmentsCount);
        this.setPatientID(patient.getPatientID());
        this.setDisease(disease);
        this.setDoctorID(doctor.getDoctorID());
        this.setSpecialization(doctor.getSpecialization());
        System.out.println("\n                 << Appointment Booked Successfully >> ");        
    }
    public void showAppointmentDetails(Doctor doctor, Patient patient){
        
        System.out.println("\n Appointment ID - " + getAppointmentID());

        System.out.println(" Patient Name - " + patient.getName());
        System.out.println(" Patient ID - " + getPatientID());       
        System.out.println(" Disease - " + getDisease() );

        System.out.println(" Doctor Name - " + doctor.getName());
        System.out.println(" Doctor ID - " + getDoctorID());         
        System.out.println(" Specialization - " + getSpecialization());
        System.out.println("");
    }
}