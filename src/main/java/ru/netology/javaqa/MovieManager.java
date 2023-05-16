package ru.netology.javaqa;

public class MovieManager {
    private final int limit;
    private Movie[] movies;

    public MovieManager() {
        this.limit = 5;
        this.movies = new Movie[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new Movie[0];
    }

    public void add(Movie movie) {
        int length = movies.length;
        Movie[] tmp = new Movie[length + 1];
        for (int i = 0; i < length; i++) {
            tmp[i] = movies[i];
        }
        tmp[length] = movie;
        movies = tmp;
        if (movies.length > limit) {
            Movie[] newMovies = new Movie[limit];
            for (int i = 0; i < limit; i++) {
                newMovies[i] = movies[movies.length - limit + i];
            }
            movies = newMovies;
        }
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength;
        if (movies.length >= limit) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[resultLength - i - 1];
        }
        return result;
    }
}
