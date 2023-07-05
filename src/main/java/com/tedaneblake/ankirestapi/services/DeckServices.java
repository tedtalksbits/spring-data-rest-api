package com.tedaneblake.ankirestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedaneblake.ankirestapi.models.Deck;
import com.tedaneblake.ankirestapi.repositories.DeckRepository;

@Service
public class DeckServices {

  private final DeckRepository deckRepository;

  @Autowired
  public DeckServices(DeckRepository deckRepository) {
    this.deckRepository = deckRepository;
  }

  /**
   * 
   * Finds all decks
   * 
   * @return all decks in the database
   */

  public List<Deck> findAllDecks() {
    return deckRepository.findAll();

  }
}
