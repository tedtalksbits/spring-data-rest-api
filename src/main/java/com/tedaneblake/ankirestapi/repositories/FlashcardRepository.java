package com.tedaneblake.ankirestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tedaneblake.ankirestapi.models.Flashcard;
import org.springframework.data.repository.query.Param;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
  List<Flashcard> findByType(@Param("type") String type);
}
