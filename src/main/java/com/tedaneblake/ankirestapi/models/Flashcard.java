package com.tedaneblake.ankirestapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "flashcards")
public class Flashcard {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long deckId;
  private String question;
  private String answer;
  private String tags;
  private String hint;
  private int masteryLevel;
  private String image;
  private String audio;
  private String video;
  private String type;

  public Flashcard() {
  }

  public Flashcard(Long id, Long deckId, String question, String answer, String tags, String hint, int masteryLevel,
      String image, String audio, String video, String type) {
    this.id = id;
    this.deckId = deckId;
    this.question = question;
    this.answer = answer;
    this.tags = tags;
    this.hint = hint;
    this.masteryLevel = masteryLevel;
    this.image = image;
    this.audio = audio;
    this.video = video;
    this.type = type;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDeckId() {
    return this.deckId;
  }

  public void setDeckId(Long deckId) {
    this.deckId = deckId;
  }

  public String getQuestion() {
    return this.question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getAnswer() {
    return this.answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getTags() {
    return this.tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getHint() {
    return this.hint;
  }

  public void setHint(String hint) {
    this.hint = hint;
  }

  public int getMasteryLevel() {
    return this.masteryLevel;
  }

  public void setMasteryLevel(int masteryLevel) {
    this.masteryLevel = masteryLevel;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getAudio() {
    return this.audio;
  }

  public void setAudio(String audio) {
    this.audio = audio;
  }

  public String getVideo() {
    return this.video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
