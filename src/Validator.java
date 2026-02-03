import java.util.Scanner;

public class Validator {
    public static String readText(Scanner scanner, String prompt) {
        String text;
        do {
            System.out.print(prompt);
            text = scanner.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("No puede estar vacío. Intente de nuevo.");
            }
        } while (text.isEmpty());

        return text;
    }

    public static String readID(Scanner scanner, String prompt) {

        String ID;
        do {
            System.out.print(prompt);
            ID = scanner.nextLine();

            if (!ID.matches("\\d+")) {
                System.out.println("El ID debe ser numérico.");
            }

        } while (!ID.matches("\\d+"));

        return ID;
    }
}
