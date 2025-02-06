class New1{
    public static void main(String[] args) {
        String name = "Sabari  prabhu";
        System.out.println(validateName(name));

    }
    public static boolean validateName(String Name){
        Name = Name.toLowerCase();
        for(int i = 0; i < Name.length(); i++){
            if(Name.charAt(i) >= 97 && Name.charAt(i) <= 122){
                continue;
            }
            else if(Name.charAt(i) == ' ')
                continue;
            else
                return false;
        }
        return true;
    }
}