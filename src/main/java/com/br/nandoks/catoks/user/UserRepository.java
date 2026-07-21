package com.br.nandoks.catoks.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface UserRepository extends JpaRepository<User, Long> {
}
