import java.util.InputMismatchException;
import java.util.Scanner;
class TypeErrorFreeInput{

    // Fieldname => Getting input for Particular field
    public int get_Input_Int(String fieldName){
        String errormsg = " must be in Int type.";
        Scanner scan = new Scanner(System.in);
        int input = 0;
        try{
            System.out.println("Enter " + fieldName + " : ");
            input = scan.nextInt();
        }
        catch(InputMismatchException e){
            Main m = new Main();
            m.setTypeErrorStatus(true);               // Set TypeErrorStatus as TRUE 
            System.out.println("\nError !! " + fieldName + errormsg);
        }
        
        return input;
    }
    public String get_Input_String(String fieldName){
        String errormsg = " must be in String type.";
        Scanner scan = new Scanner(System.in);
        String input = "";
        try{
            System.out.println("Enter " + fieldName + " : ");
            input = scan.nextLine();
        }
        catch(InputMismatchException e){
            Main m = new Main();
            m.setTypeErrorStatus(true);               // Set TypeErrorStatus as TRUE 
            System.out.println("\nError !! " + fieldName + errormsg);
        }
        return input.trim();
    }
}