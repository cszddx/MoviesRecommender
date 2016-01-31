package com.analysis.movie.dao.impl;

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
import com.analysis.movie.entity.Similarity;

@Repository
public class SimilarityDaoImpl implements SimilarityDao {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Similarity> getSimilarities(long userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("from Similarity as similarity left outer join fetch similarity.usersByUserid as users where users.userid = :userId");
        query.setParameter("userId", userId);
        @SuppressWarnings("unchecked")
        List<Similarity> result = query.list();

        return result;
    }

    @Override
    public void insertSimilarities(Set<UserSimilarity> similarities) {
        // bulk insert

    }
}
