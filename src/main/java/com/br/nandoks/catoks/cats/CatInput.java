package com.br.nandoks.catoks.cats;

import com.br.nandoks.catoks.enums.Gender;

import java.time.LocalDate;
import java.util.Date;

public record CatInput(
        String name,
        LocalDate birthday,
        Gender gender
) {
}
