package com.analysis.movie.cli;

import java.io.Console;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.analysis.movie.common.RecommendedMovie;
import com.analysis.movie.recommend.api.Recommender;
import com.analysis.movie.recommend.impl.TopNRecommender;

/**
 * The main class of the recommendation system. User id and recommendation number of movies are requested to input.
 *
 * @author duxin
 *
 */
public class MainConsole {
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
        long userId = readUserIdFromConsole();
        int number = readNumberFromConsole();

        Recommender cfRecommender = CONTEXT.getBean("cfRecommender", Recommender.class);
        Recommender topNRecommender = new TopNRecommender(cfRecommender, number, getMovieComparator());
        List<RecommendedMovie> moviesRecommended = topNRecommender.getRecommendations(userId);

        for (RecommendedMovie movie : moviesRecommended) {
            System.out.println(movie);
        }
    }

    private static int readNumberFromConsole() {
        String numberInput = readDataFromConsole("Please input the number of movies recommending to this user:");
        int number = 0;
        try {
            number = Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            System.err.println("Please input a valid number.");
            readNumberFromConsole();
        }

        if (number <= 0) {
            System.err.println("The number must be greater than 0.");
            readNumberFromConsole();
        }

        return number;
    }

    private static long readUserIdFromConsole() {
        String userIdInput = readDataFromConsole("Please input the user id:");
        long userId = 0;
        try {
            userId = Long.parseLong(userIdInput);
        } catch (NumberFormatException e) {
            System.err.println("Please input a valid user id.");
            readUserIdFromConsole();
        }

        if (userId <= 0) {
            System.err.println("User Id must be greater than 0.");
            readUserIdFromConsole();
        }

        return userId;
    }

    /**
     * Sort the movies firstly by the average rating marked by these people in descending order . The second sort
     * criterion is the popularity of movies. That means a movie watched by a large number of people is more likely to
     * be recommended than those movies watched by few people.
     *
     * @return
     */
    private static Comparator<RecommendedMovie> getMovieComparator() {
        return new Comparator<RecommendedMovie>() {
            @Override
            public int compare(RecommendedMovie o1, RecommendedMovie o2) {
                int ratingCompareResult = Double.compare(o2.getAvgRating(), o1.getAvgRating());
                if (ratingCompareResult == 0) {
                    return Double.compare(o2.getCount(), o1.getCount());
                } else {
                    return ratingCompareResult;
                }
            }
        };
    }

    private static String readDataFromConsole(String prompt) {
        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("Console is not available!");
        }

        return console.readLine(prompt);
    }
}
