package com.cashonline.marasco.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioDto {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    public UsuarioDto( @NotBlank @Email String email, @NotBlank String firstName, @NotBlank String lastName) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
