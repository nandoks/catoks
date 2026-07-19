package com.br.nandoks.catoks.user;

import com.br.nandoks.catoks.cats.Cat;
import com.br.nandoks.catoks.enums.Gender;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Cat> cat;

    String firstName;
    String lastName;
    String email;
    String phone;

    @Enumerated(EnumType.STRING)
    @Nullable
    Gender gender;

}
