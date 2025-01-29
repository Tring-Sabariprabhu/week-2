class Main
{
    public static void main(String[] args) 
    {
        Profile person = new Profile("Sabari", "TRLINTERN026");
        person.setUsername("   "); // Make Username Invalid
        try {
            person.validateName();
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage()); 
        }
    }
}
