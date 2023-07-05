package com.tedaneblake.ankirestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tedaneblake.ankirestapi.models.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
  List<Flashcard> findByType(String type);
}
