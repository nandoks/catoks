package com.br.nandoks.catoks.human;

import jakarta.transaction.Transactional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HumanController {

    private HumanRepository humanRepository;

    public HumanController(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @QueryMapping
    public List<Human> findAllHumans() {
        return humanRepository.findAll();
    }

    @QueryMapping
    public Human findHumanById(@Argument Long id) {
        return humanRepository.findById(id).orElseThrow(() -> new RuntimeException("No Human found with id " + id));
    }

    @MutationMapping
    @Transactional
    public Human addNewHuman(@Argument HumanInput humanInput) {
        var human = new Human();
        human.setEmail(humanInput.email());
        human.setFirstName(humanInput.firstName());
        human.setLastName(humanInput.lastName());
        human.setPhone(humanInput.phone());
        return humanRepository.save(human);
    }

}
