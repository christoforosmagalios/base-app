package com.github.cmag.baseapp.repository;

import com.github.cmag.baseapp.model.User;
import org.springframework.stereotype.Repository;

/**
 * An interface UserRepository that is used to declare crud methods.
 */
@Repository
public interface UserRepository extends BaseRepository<User> {

}
