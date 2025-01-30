import java.util.*;
class LearnHashMap {
    public static void main(String args[])
    {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(10, "Ravi");
        map.put(11, "Raju");
        map.put(12, "Rayan");
        System.out.println("  Map Contains \"Ravi\" : " + map.containsValue("Ravi"));
        
        for( int key : map.keySet()){
            System.out.println(" Key = " +key+ " Value =  " +map.get(key) );
        }

    }
}