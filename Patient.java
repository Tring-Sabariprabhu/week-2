import java.util.ArrayList;

interface PatientPage{
    void putAppointmentDetails( Appointment appointment);
    void showPatientDetails();
    void showBookedAppointmentsList();
}

class Patient implements PatientPage{
    private int patientID;
    private String name;
    private int age;

    private  ArrayList<Appointment> bookedAppointments = new ArrayList<>();
    
    public Patient(String name, int age){
        this.name = name;
        this.age = age;
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

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getPatientID(){
        return patientID;
    }
    @Override
    public void putAppointmentDetails( Appointment appointment){
        bookedAppointments.add(appointment);
    }

    public int getSizeOfAppointmentsList(){
        return bookedAppointments.size();
    }
    
    @Override
    public void showPatientDetails()
    {
        System.out.println(" Patient name - " + this.name);
        System.out.println(" Patient ID - " + this.patientID);
        System.out.println(" Patient Age - " + this.age);
        System.out.println(" Your Booked Appointments count - " + this.getSizeOfAppointmentsList());
        System.out.println("\n");
    }
    @Override
    public void showBookedAppointmentsList()
    {
        Storage storage = new Storage();
        System.out.print("Patient ");

        if (getSizeOfAppointmentsList() == 0) {          // Size of the Appointments details, booked by Patient
            System.out.print(getName()+ " Have ");
            System.out.println("\n0 booked Appointments !");
            return ;
        }
        System.out.println( name + " Have " + bookedAppointments.size() + " Booked Appointments");
        System.out.println("Here's booked Appointments List->");

        for(Appointment appointment : bookedAppointments ){
            Doctor doctor = (storage.getDoctorDetails( appointment.getDoctorID() ));
            System.out.println(" Appointment ID : " + appointment.getAppointmentID());
            System.out.println(" Doctor ID : " + appointment.getDoctorID());
            System.out.println(" Doctor name : " + doctor.getName());
            System.out.println(" Specialization : " + doctor.getSpecialization());
            System.out.println(" Disease : " + appointment.getDisease() + "\n");
        }
    }
    
}