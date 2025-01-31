import java.util.HashMap;
import java.util.Scanner;

class Main {
    static HashMap<Integer, Patient> patients = new HashMap<>();
    static HashMap<Integer, Doctor> doctors = new HashMap<>();
    static int appointmentsCount = 0;
    static int patientsCount = 0;
    static int doctorsCount = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Choice;
        do{
            Doctor doctor;
            Patient patient;
            int doctorID;
            int patientID;

            System.out.println("------------------------------------------------");
            System.out.println("\n1 - Create Doctor details \n2 - Create Appointment \n3 - Doctors count \n4 - Patients count \n5 - Appointment details (Doctor view) \n6 - Appointment details (Patient view) \n7 - Exit\n");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your Choice : ");
            Choice = scan.nextInt();
            switch (Choice) {
                case 1:
                    System.out.println("Creating Doctor details..\n");
                    //Creating & Saving Doctor Details
                    doctor = inputDoctorDetails();
                    AddDoctorDetails(doctor);

                    //Show entered Doctor details
                    System.out.println("\nEntered Doctor Details->");
                    doctor.showDoctorDetails();
                    break;
                case 2:
                    if(checkDoctorsListIsEmpty()){
                        System.out.println("You can't Create Appointment. Because No Doctors details found!");
                        break;
                    }
                    
                    System.out.println("Creating Appointment ..\n");
                    System.out.println("We need you to Select Doctor you want to book Appointment..");
                    showDoctorsDetails();

                    //Selecting a Doctor
                    System.out.println("Select Doctor..");
                    System.out.print("Enter Doctor ID: ");
                    doctorID = scan.nextInt();
                    
                    //If No Doctor found in this ID
                    if(doctors.containsKey(doctorID) == false){
                        System.out.println("No Doctors found in this ID !!");
                        break;
                    }

                    doctor = doctors.get(doctorID);  // Fetch Doctor Details
                    System.out.println("\nSelected Doctor Details->");
                    doctor.showDoctorDetails();

                    //Getting Patient Details
                    System.out.println("We need Patient Details for Creating Appointment..");

                    //Confirm that Patient have ID or not ?
                    System.out.print("Do you already having PatientID.? ( 1 => true | 0 => false ) : ");
                    int isAlreadyThere = scan.nextInt();

                    if(isAlreadyThere == 1){
                        //If they have ID, login with ..
                        System.out.print("\n Enter Patient ID : ");
                        patientID = scan.nextInt();

                        //If No Patient found in this ID
                        if(patients.containsKey(patientID) == false){
                            System.out.println("Patient not found in this ID !!");
                            break;
                        }
                        patient = patients.get(patientID);  // Fetch Patient Class
                        System.out.println("\nSelected Patient Details->");
                        }
                    else{
                        System.out.println("\nSo, you need to Enter Patient details ..");
                        patient = inputPatientDetails();

                        //Saving Patient details
                        AddPatientDetails(patient);

                        System.out.println("\nEntered Patient Details->");
                    }
                    
                    // Showing entered Patient Details
                    patient.showPatientDetails();
                    if(doctor.isAlreadyHaveAppointment(patient.getPatientID())){
                        System.out.println("\nSorry!! You Already Have Appointment with this Doctor. Am I right? ");
                        
                        System.out.println("Here's your Appointment details ..");
                        (doctor.getAppointmentFromMap(patient.getPatientID())).showAppointmentDetails(doctor, patient);
                        break;
                    }
                    System.out.println("To Creating Appointment we need Info about Disease..");
                    String disease = inputDiseaseDetails();
    
                    //Creating Appointment                                           
                                                    // appointment.createAppointment(doctorname, patient.getName());
                    Appointment appointment = new Appointment();
                    appointment.createAppointment(doctor, patient, disease);    // Arguments -> (Doctor, Patient, disease)

                    //Updating appointments details to Doctor Class & Patient Class
                    doctor.putAppointmentToMap(patient.getPatientID(), appointment);
                    patient.putAppointmentToList(appointment);

                    // Showing Appointment details
                    System.out.println("\nBooked Appointment Details..");
                    (doctor.getAppointmentFromMap(patient.getPatientID())).showAppointmentDetails(doctor, patient);

                    
                    break;
                case 3:
                    if(checkDoctorsListIsEmpty()){
                        break;
                    }
                    System.out.println("Doctors count - " + doctorsCount);
                    break;
                case 4:
                    if(checkPatientsListIsEmpty()){
                        break;
                    }
                    System.out.println("Patients count - " + patientsCount);
                    break;
                case 5:
                    if(checkDoctorsListIsEmpty()){
                        break;
                    }
                    System.out.print("Enter Doctor ID: ");
                    doctorID = scan.nextInt();


                    if(doctors.containsKey(doctorID) == false){
                        System.out.println("\nSorry! Appointment List can't be listed. Because No Doctors in this ID");
                        break;
                    }

                    doctor = doctors.get(doctorID);

                    System.out.println("\nSelected Doctor Details->");
                    doctor.showDoctorDetails();

                    //Showing Appointment List for Doctor
                    doctor.showAppointmentsList();
                    break;
                case 6:
                    if(checkPatientsListIsEmpty()){
                        break;
                    }
                    System.out.print("Enter Patient ID: ");
                    patientID = scan.nextInt();

                    if(patients.containsKey(patientID) == false){
                        System.out.println("\nSorry! Appointment List can't be listed. Because No Patients in this ID");
                        break;
                    }

                    patient = patients.get(patientID);

                    System.out.println("\nSelected Patient Details->");
                    patient.showPatientDetails();

                    //Showing Appointment List for Patient
                    patient.showBookedAppointmentsList();
                    break;
                case 7:
                    System.out.println("Program Terminated..");
                    break;
                default:
                    throw new AssertionError();
            }
            
        }while(Choice < 8);
    }
    public static Doctor inputDoctorDetails(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Requirement Details for doctor: ");
        System.out.print(" Doctor Name : ");
        String name = scan.nextLine();
        System.out.print(" Doctor's Specialization : ");
        String specialization = scan.nextLine();

        //Creating Doctor class
        Doctor doctor = new Doctor(name, specialization);

        //Setting Doctor ID
        doctorsCount++;
        doctor.setDoctorID(doctorsCount);

        return doctor;
    }
    public static Patient inputPatientDetails(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Requirement Details for patient: ");
        System.out.print(" Patient Name : ");
        String name = scan.nextLine();
        System.out.print(" Patient Age : ");
        int age = scan.nextInt();
        System.out.println("");
        
        //Creating Patient class
        Patient patient = new Patient(name, age);

        //Setting Patient ID
        patientsCount++;
        patient.setPatientID(patientsCount);

        return patient;
    }
    public static String inputDiseaseDetails(){
        Scanner scan = new Scanner(System.in);
        System.out.print(" Enter Disease name : ");
        return (scan.nextLine());
    }
    public static void AddDoctorDetails(Doctor doctor){
        doctors.put(doctor.getDoctorID(), doctor);
        System.out.println("\n                 << Doctor details Added Successfully >> ");
    }
    public static void AddPatientDetails(Patient patient){
        patients.put(patient.getPatientID(), patient);
        System.out.println("\n                 << Patient details Added Successfully >> ");
    }

    public static void showDoctorsDetails(){
        System.out.println("Available Doctors with Specializations for your reference..\n");
        for(Doctor doctor: doctors.values()){
            System.out.println("\n Doctor name - "+ doctor.getName());
            System.out.println(" Doctor ID - "+ doctor.getDoctorID());
            System.out.println(" Specialization - "+ doctor.getSpecialization() + "\n");
        }
    }
    public static boolean checkDoctorsListIsEmpty(){
        if(doctors.isEmpty()){
            System.out.println("\nNo Doctors found!");
            return true;
            }   
        return false;
    }
    public static boolean checkPatientsListIsEmpty(){
        if(patients.isEmpty()){
            System.out.println("\nNo Patients found!");
            return true;
            }   
        return false;
    }
    
    
    // public static void createAppointment(Doctor doctor, Patient patient){
        
    //     doctor.IncreaseAppointmentsCount();
    //     int appointmentID = doctor.getAppointmentsCount() ;
        
    // }
    
}