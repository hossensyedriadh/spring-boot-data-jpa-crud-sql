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
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private int id;

    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Only alphabets and whitespaces allowed")
    @Length(min = 5, message = "Minimum length is 5 characters")
    @Column(name = "full_name", updatable = false, nullable = false)
    private String fullName;

    @OneToOne(targetEntity = Profile.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_reference", referencedColumnName = "id")
    private Profile profile;
}
