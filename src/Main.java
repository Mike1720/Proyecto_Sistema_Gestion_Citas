import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Administrator admin = new Administrator();

        System.out.print("Usuario: ");
        String user = input.nextLine();

        System.out.print("Contraseña: ");
        String p = input.nextLine();

        if (admin.authenticateUser(user, p)) {

            MainSystem system = new MainSystem();
            system.menu();

        } else {
            System.out.println("Acceso denegado.");
        }
    }
}