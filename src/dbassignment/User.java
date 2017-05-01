/*
* User entity class
*/
package dbassignment;


public class User {
    private int id;
    private String username;
    private String password;
    private boolean admin;

    public User(int id, String username, String password, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + '}';
    }
    
    
    
}
