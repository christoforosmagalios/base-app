package com.github.cmag.baseapp.mapper;

import com.github.cmag.baseapp.dto.UserDTO;
import com.github.cmag.baseapp.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper extends BaseMapper<UserDTO, User> {

}
