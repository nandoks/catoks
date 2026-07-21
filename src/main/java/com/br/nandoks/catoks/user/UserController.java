package com.br.nandoks.catoks.user;

import jakarta.transaction.Transactional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @QueryMapping
    public User findUserById(@Argument Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User found with id " + id));
    }

    @MutationMapping
    @Transactional
    public User addNewUser(@Argument UserInput userInput) {
        var user = new User();
        user.setEmail(userInput.email());
        user.setFirstName(userInput.firstName());
        user.setLastName(userInput.lastName());
        user.setPhone(userInput.phone());
        return userRepository.save(user);
    }

}
