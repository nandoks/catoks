package com.br.nandoks.catoks.cats;

import jakarta.transaction.Transactional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CatController {

    private CatRepository catRepository;
    public CatController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @QueryMapping
    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    @MutationMapping
    @Transactional
    public Cat addNewCat(@Argument CatInput catInput) {
        Cat newCat = new Cat();
        newCat.setBirthday(catInput.birthday());
        newCat.setName(catInput.name());
        return catRepository.save(newCat);
    }

}
