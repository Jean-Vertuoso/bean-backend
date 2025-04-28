package br.com.vintor.business.dto.in;

public class LoginDTORequest {

    private String email;
    private String senha;

    public LoginDTORequest(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
