public class User {
    private String email;
    private String fullname;
    private String username;

    public User() {
    }

    public User(String email, String fullname, String username) {
        this.email = email;
        this.fullname = fullname;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
