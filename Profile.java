class Profile{
    private String Username;
    private String Id;
    public Profile(String Username, String Id){
        this.Username = Username;
        this.Id = Id;
    }
    public void setUsername(String Username){
        this.Username = Username;
    }
    public void setId(String Id){
        this.Id = Id;
    }
    public String getUsername(){
        return Username;
    }
    public String getId(){
        return Id;
    }
    public void validateName() {
        if (Username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty or null.");
        }
        System.out.println("Username is valid: " + Username);
    }

}