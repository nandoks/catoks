package com.br.nandoks.catoks.cats;

import com.br.nandoks.catoks.enums.Gender;
import com.br.nandoks.catoks.person.Human;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @Enumerated(EnumType.STRING)
    @Nullable
    private Gender gender;

    public Cat updateCat(CatInput catInput) {
        this.gender = catInput.gender() != null ? catInput.gender(): this.gender;
        this.birthday = catInput.birthday() != null ? catInput.birthday(): this.birthday;
        this.name = catInput.name() != null ? catInput.name() : this.name;
        return this;
    }

    //@ManyToOne(fetch = FetchType.LAZY)
    //private Human human;

}
