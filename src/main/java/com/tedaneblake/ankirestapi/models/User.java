package com.tedaneblake.ankirestapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "users")
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String email;
  private String username;
  private String password;
  private String avatar;
  private String nickname;
  private String status;
  private LocalDateTime lastLogin;
  private int failedLoginAttempts;
  private Long preferenceId;

  public User() {
  }

  public User(Long id, String name, String email, String username, String password, String avatar, String nickname,
      String status, LocalDateTime lastLogin, int failedLoginAttempts, Long preferenceId) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.username = username;
    this.password = password;
    this.avatar = avatar;
    this.nickname = nickname;
    this.status = status;
    this.lastLogin = lastLogin;
    this.failedLoginAttempts = failedLoginAttempts;
    this.preferenceId = preferenceId;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvatar() {
    return this.avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDateTime getLastLogin() {
    return this.lastLogin;
  }

  public void setLastLogin(LocalDateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public int getFailedLoginAttempts() {
    return this.failedLoginAttempts;
  }

  public void setFailedLoginAttempts(int failedLoginAttempts) {
    this.failedLoginAttempts = failedLoginAttempts;
  }

  public Long getPreferenceId() {
    return this.preferenceId;
  }

  public void setPreferenceId(Long preferenceId) {
    this.preferenceId = preferenceId;
  }

}
