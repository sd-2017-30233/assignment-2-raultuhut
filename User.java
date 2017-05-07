package app;

/**
 * Created by Raul on 4/24/2017.
 */
public class User {
    String username;
    String password;
    int type;
    public User(String username, String password, int type){
        this.username=username;
        this.password=password;
        this.type=type;
    }
    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
