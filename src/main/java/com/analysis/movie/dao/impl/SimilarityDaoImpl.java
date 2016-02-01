package com.analysis.movie.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.analysis.movie.common.UserSimilarity;
import com.analysis.movie.dao.api.SimilarityDao;

@Repository
public class SimilarityDaoImpl implements SimilarityDao {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Set<Long> getSimilarUsers(long userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("select distinct similarUsers.userId from Similarity as similarity left outer join similarity.usersByUserid as users left outer join similarity.usersBySimilaruserid as similarUsers where users.userId = :userId");
        query.setParameter("userId", userId);
        @SuppressWarnings("unchecked")
        List<Long> result = query.list();

        return new HashSet<Long>(result);
    }

    @Override
    public void insertSimilarities(Set<UserSimilarity> similarities) {
        // bulk insert

    }
}
