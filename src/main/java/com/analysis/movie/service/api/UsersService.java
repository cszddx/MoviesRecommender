package com.analysis.movie.service.api;

import java.util.List;

import com.analysis.movie.entity.Users;

public interface UsersService {
    Users getUsersInformation(long userId);

    List<Users> getAllUsers();

}
