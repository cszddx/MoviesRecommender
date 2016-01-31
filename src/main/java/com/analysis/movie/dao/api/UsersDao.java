package com.analysis.movie.dao.api;

import java.util.List;

import com.analysis.movie.entity.Users;

public interface UsersDao {
    Users getUsersInformation(long userId);

    List<Users> getAllUsers();
}
