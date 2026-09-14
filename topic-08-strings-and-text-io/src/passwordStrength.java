import java.util.Scanner;

public class passwordStrength {
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
        System.out.println("Password strength: " + passwordStrength(password));
    }

    public static int passwordStrength(String password){
        int strength = 0;String[] oldPasswords = {"password", "123456", "qwerty", "abc123", "H@sAn"};
        if(java.util.Arrays.asList(oldPasswords).contains(password)){
            System.out.println("Password is too common.");
            return 0;
        }
        
        if(password.length() >= 8){
            strength++;
        } else{
            System.out.println("Password is too short.");
            return 0;
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
