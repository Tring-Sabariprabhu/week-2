class Main
{
    public static void main(String[] args) 
    {
        Profile person = new Profile("Sabari", "TRLINTERN026");
        person.setUsername("   ");
        try {
            person.validateName();
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); 
        }
    }
}
