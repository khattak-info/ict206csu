import java.util.Scanner;
public class passwordStrenthExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        System.out.println("Confirm the password: ");
        if(password.equals(scanner.nextLine())){
            System.out.println("Password confirmed.");
        } else {
            System.out.println("Password does not match.");
        }        
        try{
            System.out.println("Password strength: " + passwordStrength(password));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Execution completed. the password was not saved");
            scanner.close();
        }
    }

    public static int passwordStrength(String password) throws Exception {
        int strength = 0;String[] oldPasswords = {"password", "123456", "qwerty", "abc123", "H@sAn"};
        if(java.util.Arrays.asList(oldPasswords).contains(password)){
            throw new Exception("Password is too common.");
        }
        
        if(password.length() >= 8){
            strength++;
        } else{
            throw new Exception("Password is too short.");
        }
        if(password.matches(".*[A-Z].*")){
            strength++;
        }
        if(password.matches(".*[a-z].*")){
            strength++;
        }
        if(password.matches(".*[0-9].*")){
            strength++;
        }
        if(password.matches(".*[!@#$%^&*()].*")){
            strength++;
        }
        return strength;
    }
}
