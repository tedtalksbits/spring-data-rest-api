package com.tedaneblake.ankirestapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "decks")
public class Deck {
  @Id
  @GeneratedValue
  private Long id;
  private Long userId;
  private String name;
  private String description;
  private String tags;
  private String image;
  private String visibility;

  public Deck() {
  }

  public Deck(Long id, Long userId, String name, String description, String tags, String image, String visibility) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.description = description;
    this.tags = tags;
    this.image = image;
    this.visibility = visibility;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTags() {
    return this.tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getVisibility() {
    return this.visibility;
  }

  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

}
