package com.tedaneblake.ankirestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tedaneblake.ankirestapi.models.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {

}
