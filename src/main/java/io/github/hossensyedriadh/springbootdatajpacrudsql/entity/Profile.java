package io.github.hossensyedriadh.springbootdatajpacrudsql.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Data
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Pattern(regexp = "^[0-9+]+$", message = "Only numbers and plus (+) allowed")
    @Length(min = 11, max = 18, message = "Length must be within 11-20 characters")
    @Column(name = "phone", nullable = false)
    private String phone;

    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email")
    @Column(name = "email", nullable = false)
    private String email;

    @Length(min = 5, message = "Minimum length is 5 characters")
    @Column(name = "address", nullable = false)
    private String address;
}
