package com.cashonline.marasco.model;



import com.sun.istack.Nullable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(message = "El mail debe ser válido")
    @NotNull(message = "Es necesario indicar un mail")
    @NotEmpty(message = "Es necesario indicar un mail")
    private String email;

    @NotNull(message = "Es necesario indicar un nombre")
    @NotEmpty(message = "Es necesario indicar un nombre")
    private String firstName;

    @NotNull(message = "Es necesario indicar un apellido")
    @NotEmpty(message = "Es necesario indicar un apellido")
    private String lastName;

    @Nullable
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private Set<Loan>loans;

    public Usuario() {
    }

    public Usuario(@Email(message = "El mail debe ser válido")
                   @NotNull(message = "Es necesario indicar un mail")
                   @NotEmpty(message = "Es necesario indicar un mail") String email,
                   @NotNull(message = "Es necesario indicar un nombre")
                   @NotEmpty(message = "Es necesario indicar un nombre") String firstName,
                   @NotNull(message = "Es necesario indicar un apellido")
                   @NotEmpty(message = "Es necesario indicar un apellido") String lastName, Set<Loan> loans) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loans = loans;
    }

    public long getId() {
        return id;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public void setId(long id) {
        this.id = id;
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
