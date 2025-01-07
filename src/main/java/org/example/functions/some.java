import java.util.*;

public class InsecureCodeExample {
    
    public static void main(String[] args) {
        
        // Hardcoding sensitive information - often flagged by CodeQL
        String dbPassword = "my_secret_password";
        String apiKey = "12345-ABCDE-67890";
        
        // SQL Injection vulnerability - vulnerable to CodeQL detection
        String userInput = "' OR '1'='1";
        String query = "SELECT * FROM users WHERE username='" + userInput + "' AND password='" + dbPassword + "'";

        // Unsafe deserialization example - can be flagged
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("somefile.ser"));
            Object object = in.readObject(); // Unsafe deserialization
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Use of weak encryption algorithm
        String encryptedPassword = encryptWithWeakAlgorithm(dbPassword);

        System.out.println("Encrypted password: " + encryptedPassword);
    }

    // A weak encryption method that can be flagged
    public static String encryptWithWeakAlgorithm(String password) {
        // Using MD5 (which is weak and insecure) for encryption
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encrypted = md.digest(password.getBytes());
            return new String(encrypted);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
