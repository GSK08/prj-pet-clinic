package com.example.clinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "PET")
@Setter
@NoArgsConstructor
@Getter
public class Pet implements Serializable {
    @Id
    @SequenceGenerator(
            name = "pet_sequence",
            sequenceName = "pet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pet_sequence"
    )
    private Long id;
    @Column(name = "registration_number")
    private UUID regNumber = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "pet_type")
    private PetType petType;
    @Column(name = "registration_date")
    private LocalDate date = LocalDate.now();
    @Column(name = "adopted")
    private boolean isAdopted = false;
    @ManyToOne
    @JoinColumn(name = "affiliate_id")
    private Affiliate affiliate;

    public Pet(String name, int age, PetType petType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
    }
}
