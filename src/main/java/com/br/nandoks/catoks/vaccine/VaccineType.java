package com.br.nandoks.catoks.vaccine;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class VaccineType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Nullable
    private String abreviation;
    @Nullable
    private String description;

    @OneToMany(mappedBy = "vaccineType")
    private List<Vaccine> vaccine;

}
