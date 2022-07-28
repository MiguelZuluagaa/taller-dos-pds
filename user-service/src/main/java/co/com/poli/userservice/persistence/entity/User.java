package co.com.poli.userservice.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "El apellido no puede estar vacio")
    private String lastName;

}

