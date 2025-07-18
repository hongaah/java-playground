package cn.itsource.springbootdemo.projects.json;

public class User {
    private Long id;
    private String username;
    private String password;

    public User(Long id, String username, String password) {
        this.password = password;
        this.username = username;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}