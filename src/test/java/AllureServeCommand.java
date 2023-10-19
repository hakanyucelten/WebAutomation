public class AllureServeCommand {
    public static void main(String[] args) {
        try {
            // Create a ProcessBuilder for the Windows command
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "allure serve allure-results");

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Print the exit code (0 indicates success)
            System.out.println("Command executed with exit code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
