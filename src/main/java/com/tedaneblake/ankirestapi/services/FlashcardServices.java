package com.tedaneblake.ankirestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedaneblake.ankirestapi.models.Flashcard;
import com.tedaneblake.ankirestapi.repositories.FlashcardRepository;

@Service
public class FlashcardServices {

  private final FlashcardRepository flashcardRepository;

  @Autowired
  public FlashcardServices(FlashcardRepository flashcardRepository) {
    this.flashcardRepository = flashcardRepository;
  }

  /**
   * 
   * Finds all flashcards
   * 
   * @return all flashcards in the database
   */
  public List<Flashcard> findAllFlashcards() {
    return flashcardRepository.findAll();
  }

  /**
   * 
   * Finds a flashcard by id
   * 
   * @param id the id of the flashcard to find
   * @return the flashcard with the given id
   */

  public Flashcard findFlashcardById(Long id) {
    return flashcardRepository.findById(id).orElse(null);
  }

  /**
   * 
   * Saves a flashcard to the database
   * 
   * @param flashcard the flashcard to save
   * @return the saved flashcard
   */

  public Flashcard createFlashcard(Flashcard flashcard) {
    return flashcardRepository.save(flashcard);
  }

  /**
   * 
   * Deletes a flashcard by id from the database
   * 
   * @param id the id of the flashcard to delete
   */

  public void deleteFlashcard(Long id) {
    flashcardRepository.deleteById(id);
  }

  /**
   * 
   * Updates a flashcard in the database
   * 
   * @param flashcard the flashcard to update
   * @return the updated flashcard
   */

  public Flashcard updateFlashcard(Long id, Flashcard flashcard) {

    return flashcardRepository.findById(id)

        .orElseGet(() -> {
          flashcard.setId(id);
          return flashcardRepository.save(flashcard);
        });

  }

}
