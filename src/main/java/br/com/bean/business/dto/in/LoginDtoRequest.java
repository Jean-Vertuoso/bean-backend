package br.com.bean.business.dto.in;

public class LoginDtoRequest {

    private String email;
    private String password;

    public LoginDtoRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
