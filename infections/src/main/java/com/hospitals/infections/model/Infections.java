package com.hospitals.infections.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter @Setter @ToString
@Entity
@Table(name="patient")
public class Infections extends RepresentationModel<Infections> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "hospitalName", nullable = false)
    private String hospitalName;

    @Column(name = "stoolType", nullable = false)
    private String stoolType;

    @Column(name = "puke", nullable = false)
    private boolean puke;

    @Column(name = "abdominalPain", nullable = false)
    private boolean abdominalPain;

    @Column(name = "patientsNumber", nullable = false)
    private String patientsNumber;

    @Column(name = "comment")
    private String comment;

    public Infections withComment(String comment) {
        this.setComment(comment);
        return this;
    }
}
