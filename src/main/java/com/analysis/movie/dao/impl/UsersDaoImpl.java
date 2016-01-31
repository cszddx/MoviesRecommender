package com.analysis.movie.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.analysis.movie.dao.api.UsersDao;
import com.analysis.movie.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Users getUsersInformation(long userId) {
        Session session = sessionFactory.getCurrentSession();

        return (Users) session.get(Users.class, userId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Users> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users");
        @SuppressWarnings("unchecked")
        List<Users> result = query.list();

        return result;
    }
}
