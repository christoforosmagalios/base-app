package com.github.cmag.baseapp.controller;

import com.github.cmag.baseapp.dto.UserDTO;
import com.github.cmag.baseapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that contains CRUD endpoints for the User.
 */
@Validated
@RestController
@RequestMapping("/users")
@Api(tags="User")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * Find all the Users by taking into account the given Pageable.
   *
   * @param pageable Contains pagination info.
   * @return The Page result.
   */
  @Operation(summary = "Find all the users.")
  @GetMapping
  public Page<UserDTO> findAll(Pageable pageable) {
    return userService.findAll(pageable);
  }

  /**
   * Find the User with the given id.
   *
   * @param id The User id.
   * @return The UserDTO.
   */
  @Operation(summary = "Find a user based on the id.")
  @GetMapping("{id}")
  public UserDTO getUser(@PathVariable("id") String id) {
    return userService.findOne(id);
  }

  /**
   * Save the given userDTO.
   *
   * @param userDTO The userDTO to be saved.
   * @return The saved userDTO.
   */
  @Operation(summary = "Create or update a user.")
  @PostMapping
  public UserDTO save(@Valid @RequestBody UserDTO userDTO) {
    return userService.save(userDTO);
  }

  /**
   * Delete the User with the given id.
   *
   * @param id The User id.
   */
  @Operation(summary = "Delete a user.")
  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") String id) {
    userService.delete(id);
  }

}
