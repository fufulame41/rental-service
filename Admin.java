public class Admin extends Person {
    private String username;
    private String password;

    public Admin(String id, String name, String username, String password) {
        super(id, name);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
