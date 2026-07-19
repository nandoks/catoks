package com.br.nandoks.catoks.human;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface HumanRepository  extends JpaRepository<Human, Long> {
}
