public class Logger {

    // Step 1: Create a single static instance
    private static Logger instance = new Logger();

    // Step 2: Make constructor private
    private Logger() {
        System.out.println("Logger instance created");
    }

    // Step 3: Public method to access the instance
    public static Logger getInstance() {
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}