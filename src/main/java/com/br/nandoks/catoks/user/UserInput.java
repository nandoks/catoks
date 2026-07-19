package com.br.nandoks.catoks.user;

import com.br.nandoks.catoks.enums.Gender;

public record UserInput(
        String firstName,
        String lastName,
        String phone,
        String email,
        Gender gender
) {
}
