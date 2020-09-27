package com.github.cmag.baseapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO encapsulating the user details.
 */
@Data
@NoArgsConstructor
public class UserDTO extends BaseDTO {

  @Size(max = 255)
  @NotNull
  @NotEmpty
  private String firstname;

  @Size(max = 255)
  @NotNull
  @NotEmpty
  private String lastname;

  @Size(max = 255)
  @NotNull
  @NotEmpty
  private String email;
}
