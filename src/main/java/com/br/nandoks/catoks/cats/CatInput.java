package com.br.nandoks.catoks.cats;

import java.time.LocalDate;
import java.util.Date;

public record CatInput(
        String name,
        LocalDate birthday
) {
}
