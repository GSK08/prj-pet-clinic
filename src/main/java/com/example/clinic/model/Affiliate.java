package com.example.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "AFFILIATE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Affiliate implements Serializable {
    @Id
    @SequenceGenerator(
            name = "affiliate_sequence",
            sequenceName = "affiliate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "affiliate_sequence"
    )
    private Long id;
    @Column(name = "affiliate_email")
    private String email;
    @Column(name = "affiliate_password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "affiliate_gender")
    private Gender gender;
    @Column(name = "registration_time")
    private LocalDateTime registrationTime = LocalDateTime.now();
    @Column(name = "affiliate_name")
    private String name;
    @Column(name = "affiliate_surname")
    private String surname;
    @OneToMany
    @JoinColumn(name = "affiliate_id")
    private List<Pet> pets;

    public Affiliate(String email, String password, Gender gender, String name, String surname) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Affiliate{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
