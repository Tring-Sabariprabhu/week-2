
import java.util.HashMap;
interface StoragePage{
    void AddDoctorDetails(Doctor doctor);
    void AddPatientDetails(Patient patient);
    void showDoctors();
}
class Storage implements StoragePage{
    static HashMap<Integer, Patient> patients = new HashMap<>();   
    static HashMap<Integer, Doctor> doctors = new HashMap<>();
    static int total_appointmentsCount = 0; // Only for Generating ID of APPOINTMENT
    static int patientsCount = 0;           // Only for Generating ID of PATIENT
    static int doctorsCount = 0;           // Only for Generating ID of DOCTOR
    
    public int getSizeOfDoctorsList(){                            // Size of Doctors  List
        return doctors.size();
    }
    public int getSizeOfPatientsList(){                           // Size of Patients List
        return patients.size();
    }
    public void setDoctorsCount(int doctorsCount){
        this.doctorsCount = doctorsCount;
    }
    public void setPatientsCount(int patientsCount){
        this.patientsCount = patientsCount;
    }
    public void setAppointmentsCount(int total_appointmentsCount){
        this.total_appointmentsCount = total_appointmentsCount;
    }
    public int getDoctorsCount(){
        return doctorsCount;
    }
    public int getPatientsCount(){
        return patientsCount;
    }
    public int getAppointmentsCount(){
        return total_appointmentsCount;
    }
    
    public boolean ifDoctorIsInList(int doctorID){               // Doctor is Present in LIst
        return doctors.containsKey(doctorID); 
    }
    public boolean ifPatientIsInList(int patientID){             //  Patient is Present in LIst
        return patients.containsKey(patientID);
    }
    public Doctor getDoctorDetails(int doctorID){                // get Doctor details
        return doctors.get(doctorID);
    }
    public Patient getPatientDetails(int patientID){             // get Patient details
        return patients.get(patientID);
    }

    public void AddDoctorDetails(Doctor doctor){
        doctors.put(doctor.getDoctorID(), doctor);
        System.out.println("\n <<<<<<<<<<<<<<<<<<<<<<< Doctor details Saved Successfully >> ");
    }
    public void AddPatientDetails(Patient patient){
        patients.put(patient.getPatientID(), patient);
        System.out.println("\n <<<<<<<<<<<<<<<<<<<<<<< Patient details Saved Successfully >> ");
    }

    public void showDoctors(){
        System.out.println("Available Doctors with Specializations for your reference..\n");
        for(Doctor doctor: doctors.values()){
            System.out.println("\n Doctor name - "+ doctor.getName());
            System.out.println(" Doctor ID - "+ doctor.getDoctorID());
            System.out.println(" Specialization - "+ doctor.getSpecialization() + "\n");
        }
    }
}