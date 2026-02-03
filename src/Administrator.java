public class Administrator {
    private String user = "admin";
    private String password = "password123";

    public boolean authenticateUser(String inputUser, String inputPassword) {
        return user.equals(inputUser) && password.equals(inputPassword);
    }
}
