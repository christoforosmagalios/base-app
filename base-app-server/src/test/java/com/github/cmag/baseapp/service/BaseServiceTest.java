package com.github.cmag.baseapp.service;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.cmag.baseapp.config.AppConstants;
import com.github.cmag.baseapp.dto.UserDTO;
import com.github.cmag.baseapp.mapper.UserMapper;
import com.github.cmag.baseapp.model.User;
import com.github.cmag.baseapp.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Contains test methods for the {@link BaseService}.
 */
@ExtendWith(MockitoExtension.class)
public class BaseServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserMapper mapper;

  // Dummy id to be used in tests.
  private static final String ID = "uuid";
  // A Pageable with sorting.
  private Pageable pageable = PageRequest.of(0, 5, Sort.by(AppConstants.UPDATED_ON).descending());
  // A Pageable without sorting.
  private Pageable pageableUnsorted = PageRequest.of(0, 5);

  /**
   * Test for the find all method.
   */
  @Test
  void findAllTest() {
    // Test data.
    List<User> users = new ArrayList<>();
    List<UserDTO> userDTOS = new ArrayList<>();
    // Test mocks.
    mock(BaseService.class, CALLS_REAL_METHODS);
    when(userRepository.findAll()).thenReturn(users);
    when(mapper.mapToDTOs(users)).thenReturn(userDTOS);
    // Tests.
    userService.findAll();
    verify(userRepository, times(1)).findAll();
    verify(mapper, times(1)).mapToDTOs(users);
  }

  /**
   * Test for the paginated findAll method.
   */
  @Test
  void findAllPageTest() {
    // Test data.
    Page<User> page = new PageImpl<>(Arrays.asList(new User()));
    // Test mocks.
    when(userRepository.findAll(pageable)).thenReturn(page);
    // Tests.
    userService.findAll(pageable);
    verify(userRepository, times(1)).findAll(pageable);
  }

  /**
   * Test for the paginated findAll method. Unsorted case.
   */
  @Test
  void findAllPageUnsortedTest() {
    // Test data.
    Page<User> page = mock(Page.class);
    // Test mocks.
    when(userRepository.findAll(pageable)).thenReturn(page);
    // Tests.
    userService.findAll(pageableUnsorted);
    verify(userRepository, times(1)).findAll(pageable);
  }

  /**
   * Test for the findOne method.
   */
  @Test
  void findOneTest() {
    // Test data.
    Optional<User> result = Optional.empty();
    // Test mocks.
    when(userRepository.findById(ID)).thenReturn(result);
    // Tests.
    userService.findOne(ID);
    verify(userRepository, times(1)).findById(ID);
  }

  /**
   * Test for the findOne method. Optional isPresent case.
   */
  @Test
  void findOneIsPresentTest() {
    // Test data.
    Optional<User> result = Optional.of(new User());
    // Test mocks.
    when(userRepository.findById(ID)).thenReturn(result);
    // Tests.
    userService.findOne(ID);
    verify(userRepository, times(1)).findById(ID);
  }

  /**
   * Test for the save method.
   */
  @Test
  void saveTest() {
    // Test data.
    User user = new User();
    UserDTO userDTO = new UserDTO();
    // Test mocks.
    when(mapper.map(userDTO)).thenReturn(user);
    when(mapper.map(user)).thenReturn(userDTO);
    when(userRepository.save(user)).thenReturn(user);
    // Tests.
    userService.save(userDTO);
    verify(userRepository, times(1)).save(user);
  }

  /**
   * Test for the delete method.
   */
  @Test
  void deleteTest() {
    // Test mocks.
    doNothing().when(userRepository).deleteById(ID);
    // Tests.
    userService.delete(ID);
    verify(userRepository, times(1)).deleteById(ID);
  }

}
