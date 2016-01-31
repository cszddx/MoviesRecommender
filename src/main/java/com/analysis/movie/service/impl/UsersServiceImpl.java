package com.analysis.movie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.analysis.movie.dao.api.UsersDao;
import com.analysis.movie.entity.Users;
import com.analysis.movie.service.api.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public Users getUsersInformation(long userId) {
        return usersDao.getUsersInformation(userId);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }
}
