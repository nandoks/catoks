package com.br.nandoks.catoks.cats;

import com.br.nandoks.catoks.CatService;
import com.br.nandoks.catoks.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CatController {

    @Autowired
    private CatRepository catRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CatService catService;

    @QueryMapping
    public List<Cat> findAllCats() {
        return catService.findAllCats();
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
    public Cat updateCat(@Argument Long id,  @Argument CatInput catInput, @Argument Long UserId) {
        var cat  = catRepository.findById(id).orElseThrow(() -> new RuntimeException("cat not found"));
        var User = userRepository.findById(UserId).orElseThrow(() -> new RuntimeException("User not " +
                "found"));
        cat.setUser(User);
        return cat.updateCat(catInput);
    }

}
