public class functionsString {
    public static void main(String[] args) {
        String str1 = "Hasan";
        String str2 = "Khattak";

        // Concatenation
        String concatenated = str1 + " " + str2;
        System.out.println("Concatenated String: " + concatenated);

        // Length
        int length = concatenated.length();
        System.out.println("Length of Concatenated String: " + length);

        // Substring
        String substring = concatenated.substring(0, 5);
        System.out.println("Substring (0 to 5): " + substring);

        // Uppercase and Lowercase
        String upperCase = concatenated.toUpperCase();
        String lowerCase = concatenated.toLowerCase();
        System.out.println("Uppercase: " + upperCase);
        System.out.println("Lowercase: " + lowerCase);

        // Replace
        String replacedString = concatenated.replace("Hasan", "Hassan");
        System.out.println("Replaced String: " + replacedString);
    }
}