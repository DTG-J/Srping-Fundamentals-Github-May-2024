package bg.softuni.pathfinder.web.dto;


import jakarta.validation.constraints.*;

public class UserRegisterDTO {
    @NotEmpty
    @NotNull
    private String username;
@NotEmpty
@Size(min = 5)
    private String fullName;
@Email
    private String email;
@Min (0)
@Max(90)
    private String age;
@Size(min = 5)
    private String password;
    private String confirmPassword;

    public UserRegisterDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
