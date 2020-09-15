package com.github.cmag.baseapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * The User entity holds data of a user.
 */
@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {

  @Column(name = "first_name")
  private String firstname;

  @Column(name = "last_name")
  private String lastname;

  @Column(name = "email")
  private String email;
}
