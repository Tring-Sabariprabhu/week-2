                                                    
class Main {
    
    private static boolean typeErrorStatus;

    public static void setTypeErrorStatus(boolean status){
        typeErrorStatus = status;
    }
    public static boolean  getTypeErrorStatus(){
        return typeErrorStatus;
    }

    public static void main(String[] args) {
        TypeErrorFreeInput typeErrorFreeInput = new TypeErrorFreeInput();
        int Choice;
        do{
            System.out.println("________________________________________________");
            System.out.println("\n1 - Create Doctor details \n2 - Create Appointment \n3 - Doctors count \n4 - Patients count \n5 - Doctor's Profile \n6 - Patient's Profile \n7 - Appointment details (Doctor view) \n8 - Appointment details (Patient view) \n9 - Exit");
            System.out.println("________________________________________________");

            setTypeErrorStatus(false);                               // Initialize TypeErrorStatus as false
            Choice = typeErrorFreeInput.get_Input_Int("Choice");
            if(getTypeErrorStatus()){
                Choice = 1; // to run
                continue;
            }
            else if(isInvalidChoice(Choice, "Choice")){
                Choice = 1; // to run
                continue;
            }

            switch (Choice) {
                case 1:
                    System.out.println("Creating Doctor details..\n");
                    CreateDoctorDetails();
                    break;
                case 2:
                    System.out.println("Creating Appointment ..\n");
                    CreateAppointmentDetails();
                    break;
                case 3:
                    System.out.println("Showing total Doctors count ..\n");
                    ShowCountOfDoctors();
                    break;
                case 4:
                    System.out.println("Showing total Patients count ..\n");
                    ShowCountOfPatients();
                    break;
                case 5:
                    System.out.println("Showing Doctor's Profile ..\n");
                    ShowDoctorProfile();
                    break;
                case 6:
                    System.out.println("Showing Patient's Profile ..\n");
                    ShowPatientProfile();
                    break;
                case 7:
                    System.out.println("Appointments List for Particular Doctor ..\n");
                    showAppointmentsList_Doctor();
                    break;
                case 8:
                    System.out.println("Booked Appointments List for Particular Patient ..\n");
                    showAppointmentsList_Patient();
                    break;
                case 9:
                    break;
                default:
                    break;
            }
            
        }while(Choice < 9);
        System.out.println("Program Terminated..");
    }
    
    public static boolean isInvalidChoice(int input, String fieldName){
        String errormsg = " Should be 1 to 9";
        if(input < 1 || input > 9)
        {
            System.out.println("Error! " + fieldName + errormsg);
            return true;
        }
        return false;
    }
    public static boolean isInvalidResponse(int input, String fieldName){
        String errormsg = " Should be 0 or 1";
        if(input != 0 && input != 1){
            System.out.println("Error! " + fieldName + errormsg);
            return true;
        }
        return false;
    }
    public static boolean isInvalidString(String input, String fieldName)
    {
        input = input.trim().toLowerCase();
        if(input.length() == 0)
        {
            System.out.println("\nError! " + fieldName + " Shouldn't be null");
            return true;
            }
        else if(input.length() == 1){
            System.out.println("\nError! " + fieldName + " can't be Single character !");
            return true;
        }
        for(int i = 0; i < input.length(); i++){
            char letter = input.charAt(i);
            if(letter == ' ' || (letter >= 97 && letter <= 122))
                continue;
            else{
                System.out.println("\nError! " + fieldName + " Shouldn't contain Numbers, Special symbols[except Space]");
                return true;
            }
        }
        return false;
    }
    public static boolean isInvalidID(int input, String fieldName)
    {
        String errormsg = " Should be Positive number.";
        if(input <= 0)
        {
            System.out.println("Error! " + fieldName + " " + errormsg);
            return true;
            }
        return false;
    }
    public static boolean isInvalidAge(int input, String fieldName){
        if(input <= 0){
            System.out.println("Error! " + fieldName + " Should be above Zero ");
            return true;
        }
        return false;
    }
    
    public static void CreateDoctorDetails(){
        Storage storage = new Storage();
        TypeErrorFreeInput typeErrorFreeInput = new TypeErrorFreeInput();

        String ProcessStoppedMsg = "Creating Doctor details process Stopped !";
        Doctor doctor;

        //Creating & Saving Doctor Details
        System.out.println("Requirement details for Creating Doctor account: ");

        setTypeErrorStatus(false);
        String name = typeErrorFreeInput.get_Input_String("Doctor Name");
        if(getTypeErrorStatus()){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidString(name, "Doctor Name")){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false
        String specialization = typeErrorFreeInput.get_Input_String("Doctor's Specialization");
        if(getTypeErrorStatus()){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidString(specialization, "Doctor's Specialization")){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        
        //Creating Doctor class
        doctor = new Doctor(name, specialization);

        //Setting Doctor ID
        storage.setDoctorsCount( storage.getDoctorsCount() + 1 );        // doctorsCount++;
        doctor.setDoctorID(storage.getDoctorsCount());                  //  Setting Doctor ID by Doctor's Count
        storage.AddDoctorDetails(doctor);                               // Saving details

        //Show entered Doctor details
        System.out.println("\nEntered Doctor details->");
        doctor.showDoctorDetails();
    }
    public static void CreateAppointmentDetails()
    {
        Storage storage = new Storage();
        TypeErrorFreeInput typeErrorFreeInput = new TypeErrorFreeInput();

        String ProcessStoppedMsg = "Creating Appointment process stopped !";
        Doctor doctor;
        Patient patient;
        int doctorID;
        int patientID;

        if(storage.getSizeOfDoctorsList() == 0){    // Size of Saved Doctor details List
            System.out.println("You can't Create Appointment. because No Doctors details found!");
            System.out.println(ProcessStoppedMsg);
            return;
        }
        
        System.out.println("We need you to Select Doctor you want to book Appointment..");
        storage.showDoctors();                       // Show all Doctors with Specialization

        //Selecting a Doctor
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

        doctorID = typeErrorFreeInput.get_Input_Int("Doctor ID");
        if(getTypeErrorStatus()){
            // Integer Type error
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidID(doctorID, "Doctor ID")){                 // ID should be above Zero
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(storage.ifDoctorIsInList(doctorID) == false){                // Search the Doctor is in List
            System.out.println("No Doctors found in this ID !!");
            System.out.println(ProcessStoppedMsg);
            return;
        }

        doctor = storage.getDoctorDetails(doctorID);           // Fetch Doctor Details
        System.out.println("\nSelected Doctor details->");
        doctor.showDoctorDetails();

        //Getting Patient Details
        System.out.println("We need Patient details for Creating Appointment..");

        //Confirm that Patient have ID or not ?
        System.out.println("Do you already having PatientID.? ( 1 => Yes | 0 => No ) : ");
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

        int isAlreadyThere = typeErrorFreeInput.get_Input_Int("Response");

        if(getTypeErrorStatus()){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidResponse(isAlreadyThere, "Response")){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        if((isAlreadyThere == 1))
        {
            if(storage.getSizeOfPatientsList() == 0){
                System.out.println("You haven't Patient ID.  Because, No Patients found! ");
                System.out.println(ProcessStoppedMsg);
                return;
            }
            //If they have ID, login with ..
            setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

            patientID = typeErrorFreeInput.get_Input_Int("Patient ID");
            if(getTypeErrorStatus()){                                             // Integer Type error 
                System.out.println(ProcessStoppedMsg);
                return;
            }
            else if(isInvalidID(patientID, "Patient ID")){                 // ID should be above Zero
                System.out.println(ProcessStoppedMsg);
                return;
            }
            else if(storage.ifPatientIsInList(patientID) == false){                   //If No Patient found in this ID
                System.out.println("Patient not found in this ID !!");
                System.out.println(ProcessStoppedMsg);
                return;
            }

            patient =  storage.getPatientDetails(patientID);                // Fetch Patient Class
            System.out.println("\nSelected Patient details->");
            }
        else
        {
            System.out.println("\nSo, you need to Enter Patient details ..");
            System.out.println("Requirement details for Creating Patient account: ");
            // System.out.print(" Patient Name : ");

            setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

            String name = typeErrorFreeInput.get_Input_String("Patient Name");
            if(getTypeErrorStatus()){
                System.out.println(ProcessStoppedMsg);
                return;
            }
            else if(isInvalidString(name, "Patient Name")){
                System.out.println(ProcessStoppedMsg);
                return;
            }

            setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

            int age = typeErrorFreeInput.get_Input_Int("Patient Age");
            if(getTypeErrorStatus()){
                System.out.println(ProcessStoppedMsg);
                return;
            }
            else if(isInvalidAge(age, "Patient Age")){                 // ID should be above Zero
                System.out.println(ProcessStoppedMsg);
                return;
            }
            //Creating Patient class
            patient = new Patient(name, age);

            //Setting Patient ID
            storage.setPatientsCount(storage.getPatientsCount() + 1);       // patientsCount++;
            patient.setPatientID(storage.getPatientsCount());                            // Setting Patient ID by Patient's Count

            storage.AddPatientDetails(patient);                                    // Saving Patient details

            System.out.println("\nEntered Patient details->");
        }
        
        // Showing entered Patient Details
        patient.showPatientDetails();

        if(doctor.ifAlreadyHaveAppointment(patient.getPatientID())){
            System.out.println(ProcessStoppedMsg);
            System.out.println("\nSorry!! You Already Have Appointment with this Doctor?.. ");
            

            // then Show previous Appointment details and Stop the Process
            System.out.println("Here's your Appointment details ..");
            ( doctor.getAppointmentDetails(patient.getPatientID()) ).showAppointmentDetails(doctor, patient); 
            System.out.println(ProcessStoppedMsg);
            return;
        }

        // Getting Disease details
        System.out.println("To Creating Appointment we need Info about Disease..");
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

        String disease = typeErrorFreeInput.get_Input_String("Disease Name");
        if(getTypeErrorStatus()){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidString(disease, "Patient's Disease")){
            System.out.println(ProcessStoppedMsg);
            return ;
        }

        //Creating Appointment                                           
                                        // appointment.createAppointment(doctorname, patient.getName());
        Appointment appointment = new Appointment();
        appointment.createAppointment(doctor, patient, disease);    // Arguments -> (Doctor, Patient, disease)


        //Updating Appointments details to Doctor Class & Patient Class
        doctor.putAppointmentDetails(patient.getPatientID(), appointment);
        patient.putAppointmentDetails(appointment);

        // Finally.. Showing Appointment details 
        System.out.println("\nBooked Appointment details..");
        (doctor.getAppointmentDetails(patient.getPatientID())).showAppointmentDetails(doctor, patient);
    }
    public static void ShowCountOfDoctors(){
        Storage storage = new Storage();
        if(storage.getSizeOfDoctorsList() == 0)
        {
            System.out.println("\nNo Doctors found!");
            }   
        else
        {
            System.out.println("Doctors count - " + storage.getSizeOfDoctorsList());
            }
    }
    public static void ShowCountOfPatients(){
        Storage storage = new Storage();
        if(storage.getSizeOfPatientsList() == 0)
        {
            System.out.println("\nNo Patients found!");
            }
        else
        {
            System.out.println("Patients count - " + storage.getSizeOfPatientsList());
            }
    }
    public static void ShowDoctorProfile()
    {
        TypeErrorFreeInput typeErrorFreeInput = new TypeErrorFreeInput();
        Storage storage = new Storage();

        String ProcessStoppedMsg = "Showing particular Doctor's Profile process stopped !";
        Doctor doctor;
        int doctorID;
        
        if(storage.getSizeOfDoctorsList() == 0){
            System.out.println("No Doctors found! ");
            System.out.println(ProcessStoppedMsg);
            return;
        }
        //Selecting a Doctor
        
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

        doctorID = typeErrorFreeInput.get_Input_Int("Doctor ID");
        if(getTypeErrorStatus()){
            // Integer Type error
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidID(doctorID, "Doctor ID")){                 // ID should be above Zero
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(storage.ifDoctorIsInList(doctorID) == false){                // Search the Doctor is in List
            System.out.println("No Doctors found in this ID !!");
            System.out.println(ProcessStoppedMsg);
            return;
        }

        doctor = storage.getDoctorDetails(doctorID);           // Fetch Doctor Details
        System.out.println("\nFetched Doctor details->");
        doctor.showDoctorDetails();
    }
    public static void ShowPatientProfile()
    {
        TypeErrorFreeInput typeErrorFreeInput = new TypeErrorFreeInput();
        Storage storage = new Storage();

        String ProcessStoppedMsg = "Showing particular Patient's Profile process stopped !";
        Patient patient;
        int patientID;
        
        if(storage.getSizeOfPatientsList() == 0){
            System.out.println("No Patients found! ");
            System.out.println(ProcessStoppedMsg);
            return;
        }

        //Selecting a Doctor
        
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

        patientID = typeErrorFreeInput.get_Input_Int("Patient ID");
        if(getTypeErrorStatus()){
            // Integer Type error
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidID(patientID, "Patient ID")){                 // ID should be above Zero
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(storage.ifPatientIsInList(patientID) == false){                // Search the Patient is in List
            System.out.println("No Patients found in this ID !!");
            System.out.println(ProcessStoppedMsg);
            return;
        }

        patient = storage.getPatientDetails(patientID);                // Fetch Patient Details
        System.out.println("\nFetched Patient details->");
        patient.showPatientDetails();
    }
    public static void showAppointmentsList_Doctor()
    {
        TypeErrorFreeInput typeErrorFreeInput = new TypeErrorFreeInput();
        Storage storage = new Storage();

        String ProcessStoppedMsg = "Showing Appointments List process Stopped !";
        Doctor doctor;
        int doctorID;
        if(storage.getSizeOfDoctorsList() == 0){                        // Size of the Doctors details List
            System.out.println("No Doctors found !");
            return;
        }
        
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

        doctorID = typeErrorFreeInput.get_Input_Int("Doctor ID");
        if(getTypeErrorStatus()){
            // Integer Type error
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidID(doctorID, "Doctor ID")){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(storage.ifDoctorIsInList(doctorID) == false){                         // Check the Doctor is present in Doctors details List
            System.out.println("\nSorry! Appointment List can't be listed. Because No Doctors in this ID");
            return;
        }

        doctor = storage.getDoctorDetails(doctorID);

        System.out.println("\nSelected Doctor details->");
        doctor.showDoctorDetails();

        //Showing Appointment List for Doctor
        doctor.showAppointmentsList();
    }
    public static void showAppointmentsList_Patient()
    {
        TypeErrorFreeInput typeErrorFreeInput = new TypeErrorFreeInput();
        Storage storage = new Storage();

        String ProcessStoppedMsg = "Showing booked Appointments List process Stopped !";
        Patient patient;
        int patientID;
        if(storage.getSizeOfPatientsList() == 0){              // Size of the Patients details List
            System.out.println("No Patients found !");
            return;
        }
    
        setTypeErrorStatus(false);                                 // Initialze TypeErrorStatus as false

        patientID = typeErrorFreeInput.get_Input_Int("Patient ID");
        if(getTypeErrorStatus()){
            // Integer Type error
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(isInvalidID(patientID, "Patient ID")){
            System.out.println(ProcessStoppedMsg);
            return;
        }
        else if(storage.ifPatientIsInList(patientID) == false){                // Check the Patient is present in Patients details List
            System.out.println("\nSorry! Appointment List can't be listed. Because No Patients in this ID");
            return;
        }

        patient = storage.getPatientDetails(patientID);

        System.out.println("\nSelected Patient details->");
        patient.showPatientDetails();

        //Showing Appointment List for Patient
        patient.showBookedAppointmentsList();
    }
}
