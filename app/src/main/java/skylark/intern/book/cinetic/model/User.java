package skylark.intern.book.cinetic.model;

import java.io.Serializable;
@SuppressWarnings("serial")
public class User implements Serializable {
    private int userId;
    private String username,phone,email,password;

    public User(int userId, String username, String phone, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
