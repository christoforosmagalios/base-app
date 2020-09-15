package com.github.cmag.baseapp.service;

import com.github.cmag.baseapp.dto.UserDTO;
import com.github.cmag.baseapp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * A Service class for User.
 */
@Service
@RequiredArgsConstructor
public class UserService extends BaseService<UserDTO, User> {

}
