package com.br.nandoks.catoks.controller;

import com.br.nandoks.catoks.cats.Cat;
import com.br.nandoks.catoks.cats.CatController;
import com.br.nandoks.catoks.cats.CatRepository;
import com.br.nandoks.catoks.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.graphql.test.autoconfigure.GraphQlTest;
import org.springframework.boot.graphql.test.autoconfigure.tester.AutoConfigureGraphQlTester;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.web.reactive.server.WebTestClient;


@AutoConfigureGraphQlTester
public class CatControllerIntTest {

    @Test
    void simpleTestForCICDConfig() {
        System.out.println("simpleTestForCICDConfig");
        assert (2+2==4);
    }

   }
