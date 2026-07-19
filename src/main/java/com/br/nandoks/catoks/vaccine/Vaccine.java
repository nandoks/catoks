package com.br.nandoks.catoks.vaccine;

import com.br.nandoks.catoks.cats.Cat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateAdministered;
    private LocalDate nextDoseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private VaccineType vaccineType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cat cat;
}
