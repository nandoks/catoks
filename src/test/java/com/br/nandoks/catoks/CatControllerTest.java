package com.br.nandoks.catoks;


import com.br.nandoks.catoks.cats.Cat;
import com.br.nandoks.catoks.cats.CatController;
import com.br.nandoks.catoks.cats.CatRepository;
import com.br.nandoks.catoks.graphql.GraphQlConfig;
import com.br.nandoks.catoks.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.graphql.test.autoconfigure.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

@GraphQlTest(CatController.class)
@Import(GraphQlConfig.class)
public class CatControllerTest {

    @Autowired
    GraphQlTester graphQlTester;
    @MockitoBean
    CatRepository catRepository;
    @MockitoBean
    UserRepository userRepository;

    @MockitoBean
    CatService catService;

    @Test
    void testAllGetCat() {
        // language=graphql
        String document = """
                query findAllCats{
                     findAllCats {
                         id
                         name                             }
                }
         """;

        List<Cat> cats = graphQlTester.document(document)
                .execute()
                .path("findAllCats")
                .entityList(Cat.class).get();
        assert (cats.isEmpty());
    }
}
