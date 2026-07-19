package com.br.nandoks.catoks.cats;

import com.br.nandoks.catoks.human.HumanRepository;
import jakarta.transaction.Transactional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.management.relation.RoleUnresolved;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class CatController {

    private CatRepository catRepository;
    private HumanRepository humanRepository;

    public CatController(CatRepository catRepository, HumanRepository humanRepository) {
        this.catRepository = catRepository;
        this.humanRepository = humanRepository;
    }

    @QueryMapping
    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    @QueryMapping
    public Optional<Cat> findCatById(@Argument Long id) {
        return Optional.of(catRepository.findById(id).orElseThrow(() -> new RuntimeException("No Cat with id " + id)));
    }


    @MutationMapping
    @Transactional
    public Cat addNewCat(@Argument CatInput catInput) {
        Cat newCat = new Cat();
        newCat.setBirthday(catInput.birthday());
        newCat.setName(catInput.name());
        return catRepository.save(newCat);
    }

    @MutationMapping
    @Transactional
    public Cat updateCat(@Argument Long id,  @Argument CatInput catInput, @Argument Long humanId) {
        var cat  = catRepository.findById(id).orElseThrow(() -> new RuntimeException("cat not found"));
        var human = humanRepository.findById(humanId).orElseThrow(() -> new RuntimeException("human not " +
                "found"));
        cat.setHuman(human);
        return cat.updateCat(catInput);
    }

}
