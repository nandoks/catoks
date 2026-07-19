package com.br.nandoks.catoks.cats;

import com.br.nandoks.catoks.enums.Gender;
import com.br.nandoks.catoks.user.User;
import com.br.nandoks.catoks.vaccine.Vaccine;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthday;
    private Float weight;
    private Boolean neutered;

    @Enumerated(EnumType.STRING)
    @Nullable
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "cat")
    private List<Vaccine> vaccine;

    public Cat updateCat(CatInput catInput) {
        if (catInput == null){
            return this;
        }
        this.gender = catInput.gender() != null ? catInput.gender() : this.gender;
        this.birthday = catInput.birthday() != null ? catInput.birthday() : this.birthday;
        this.name = catInput.name() != null ? catInput.name() : this.name;
        return this;
    }


}
