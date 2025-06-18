package br.com.bean.business.dto.out;

public class LoginDtoResponse {

    private String token;
    private String email;

    public LoginDtoResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

}
