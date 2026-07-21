package com.br.nandoks.catoks;

import com.br.nandoks.catoks.cats.Cat;
import com.br.nandoks.catoks.cats.CatInput;
import com.br.nandoks.catoks.cats.CatRepository;
import com.br.nandoks.catoks.enums.Gender;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {

    List<Cat> cats = new ArrayList<Cat>();

    @Autowired
    private CatRepository catRepository;

    @QueryMapping
    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public Cat createCat(CatInput catInput) {
        Cat newCat = new Cat();
        newCat.setBirthday(catInput.birthday());
        newCat.setName(catInput.name());
        return catRepository.save(newCat);
    }

    @PostConstruct
    public void init() {
        CatInput catInput = new CatInput("Aleph", LocalDate.of(2025, 1, 1), Gender.MALE);
        Cat newCat = this.createCat(catInput);
        cats.add(newCat);
        CatInput anotherCatInput = new CatInput("Nina", LocalDate.of(2024, 1, 1), Gender.FEMALE);
        Cat anotherNewCat = this.createCat(anotherCatInput);
        cats.add(anotherNewCat);
    }
}

