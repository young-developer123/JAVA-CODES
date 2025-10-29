// File: LoginPortal.java
import java.io.Console;

public class MaskedLogin {

    // Predefined credentials
    private static final String USERNAME = "Elijah2025";
    private static final String PASSWORD = "Zetech@123";

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.out.println("⚠️ Console not available. Run this program in a terminal.");
            return;
        }

        int attempts = 3;

        while (attempts > 0) {
            System.out.println("\n🔐 Zetech Login System");

            String inputUser = console.readLine("👤 Username: ");
            char[] inputPass = console.readPassword("🔑 Password: ");
            String password = new String(inputPass);

            if (inputUser.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("✅ Login successful. Welcome, Elijah!");
                break;
            } else {
                attempts--;
                System.out.println("❌ Invalid credentials. Remaining attempts: " + attempts);
                if (attempts == 0) {
                    System.out.println("🚫 Access denied. Please contact admin.");
                }
            }
        }
    }
}
