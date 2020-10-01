package com.github.cmag.baseapp.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.cmag.baseapp.dto.UserDTO;
import com.github.cmag.baseapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Contains test methods for the {@link UserController}.
 */
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

  @InjectMocks
  private UserController userController;

  @Mock
  private UserService userService;

  // Dummy id to be used in tests.
  private static final String ID = "uuid";
  // A UserDTO to be used in tests.
  private UserDTO userDTO = new UserDTO();

  /**
   * Test for the findAll method.
   */
  @Test
  void findAllTest() {
    // Test data.
    Pageable pageable = PageRequest.of(0, 5);
    Page<UserDTO> page = mock(Page.class);
    // Test mocks.
    when(userService.findAll(pageable)).thenReturn(page);
    // Tests.
    userController.findAll(pageable);
    verify(userService, times(1)).findAll(pageable);
  }

  /**
   * Test for the getUser method.
   */
  @Test
  void getUserTest() {
    // Test mocks.
    when(userService.findOne(ID)).thenReturn(userDTO);
    // Tests.
    userController.getUser(ID);
    verify(userService, times(1)).findOne(ID);
  }

  /**
   * Test for the save method.
   */
  @Test
  void saveTest() {
    // Test mocks.
    when(userService.save(userDTO)).thenReturn(userDTO);
    // Tests.
    userController.save(userDTO);
    verify(userService, times(1)).save(userDTO);
  }

  /**
   * Test for the delete method.
   */
  @Test
  void deleteTest() {
    // Tests.
    userController.delete(ID);
    verify(userService, times(1)).delete(ID);
  }

}
