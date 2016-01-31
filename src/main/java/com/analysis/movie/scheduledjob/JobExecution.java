package com.analysis.movie.scheduledjob;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.analysis.movie.common.UserSimilarity;
import com.analysis.movie.service.api.SimilarityService;
import com.analysis.movie.similarity.impl.PearsonSimilarity;

/**
 * This is a Timer job which executes every night. it will iterate all the users and for every user it will get similar
 * users to update the database. If there is something when doing similarity computing or database updating for one
 * user, should retry and then continue with the next user.
 *
 * @author duxin
 *
 */
public class JobExecution {
    private final static ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        try {
            // the job is supposed to execute at midnight
            ComputeNeighbors computer = CONTEXT.getBean(ComputeNeighbors.class, 1L, 30, new PearsonSimilarity());
            ScheduledFuture<Set<UserSimilarity>> future = service.schedule(computer, 0, TimeUnit.HOURS);

            Set<UserSimilarity> similarUsers = future.get();
            // update Similarity table with new data model
            SimilarityService similarityService = CONTEXT.getBean(SimilarityService.class);
            similarityService.insertSimilarities(similarUsers);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

}
