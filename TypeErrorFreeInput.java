import java.util.InputMismatchException;
import java.util.Scanner;
class TypeErrorFreeInput{

    public int get_Input_Int(String fieldName){       // Fieldname => Getting input for Particular field
        String errormsg = " must be in Integer type.";
        Scanner scan = new Scanner(System.in);
        int input = 0;
        System.out.println("Enter " + fieldName + " : ");
        try{
            input = scan.nextInt();
        }
        catch(InputMismatchException e){
            Main.setTypeErrorStatus(true);             
            System.out.println("\nType Error !! " + fieldName + errormsg);
        }
        return input;
    }
    public String get_Input_String(String fieldName){
        String errormsg = " must be in String type.";
        Scanner scan = new Scanner(System.in);
        String input = "";
        System.out.println("Enter " + fieldName + " : ");
        try{
            input = scan.nextLine();
        }
        catch(InputMismatchException e){
            Main.setTypeErrorStatus(true);             
            System.out.println("\nType Error !! " + fieldName + errormsg);
        }
        return input.trim();
    }
}