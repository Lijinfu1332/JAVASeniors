package test;

public class user {
    private int ids;
    private  String name;
    private  String password;
    private  String email;

    public user() {
    }

    public user(int id, String name, String password, String email) {
        this.ids = ids;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return ids;
    }

    public void setId(int ids) {
        this.ids= ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + ids +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
