package com.br.nandoks.catoks.cats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
