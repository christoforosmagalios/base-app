package com.github.cmag.baseapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO encapsulating the user details.
 */
@Data
@NoArgsConstructor
public class UserDTO extends BaseDTO {

  private String firstname;
  private String lastname;
  private String email;
}
