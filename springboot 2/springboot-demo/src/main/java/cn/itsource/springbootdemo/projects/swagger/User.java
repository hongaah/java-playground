package cn.itsource.springbootdemo.projects.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户实体类")
public class User {
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Schema(description = "用户唯一标识")
    private Long id;

    @Schema(description = "用户姓名")
    private String username;

    @Schema(description = "用户密码")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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