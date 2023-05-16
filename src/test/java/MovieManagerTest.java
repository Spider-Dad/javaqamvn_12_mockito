import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Movie;
import ru.netology.javaqa.MovieManager;


public class MovieManagerTest {

    MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void shouldAddMovie() {
        Movie movie1 = new Movie("Бладшот", "боевик");
        Movie movie2 = new Movie("Вперёд", "мультфильм");
        Movie movie3 = new Movie("Отель «Белград»", "комедия");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] movies = manager.findAll();

        Assertions.assertEquals(3, movies.length);
        Assertions.assertEquals(movie1, movies[0]);
        Assertions.assertEquals(movie2, movies[1]);
        Assertions.assertEquals(movie3, movies[2]);
    }

    @Test
    public void testFindLastMovies() {
        manager = new MovieManager(3);
        Movie movie1 = new Movie("Бладшот", "боевик");
        Movie movie2 = new Movie("Вперёд", "мультфильм");
        Movie movie3 = new Movie("Отель «Белград»", "комедия");
        Movie movie4 = new Movie("Джентельмены", "боевик");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);

        Movie[] movies = manager.findLast();

        Assertions.assertEquals(3, movies.length);
        Assertions.assertEquals(movie4, movies[0]);
        Assertions.assertEquals(movie3, movies[1]);
        Assertions.assertEquals(movie2, movies[2]);
    }

    @Test
    public void testAddMoreThanLimit() {
        // Тестирование метода  при добавлении большего числа фильмов, чем лимит. Ожидается, что старые фильмы будут удалены из списка и новые будут добавлены в конец
        manager = new MovieManager(2);
        Movie movie1 = new Movie("Бладшот", "боевик");
        Movie movie2 = new Movie("Вперёд", "мультфильм");
        Movie movie3 = new Movie("Отель «Белград»", "комедия");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] movies = manager.findAll();

        Assertions.assertEquals(2, movies.length);
        Assertions.assertEquals(movie2, movies[0]);
        Assertions.assertEquals(movie3, movies[1]);
    }

    @Test
    public void testFindAllEmpty() {
        // Тестирование метода при пустом списке фильмов. Ожидается, что метод вернет пустой массив.
        manager = new MovieManager(3);
        Movie[] movies = manager.findAll();
        Assertions.assertEquals(0, movies.length);
    }

    @Test
    public void testFindLastEmpty() {
        // Тестирование метода  при пустом списке фильмов. Ожидается, что метод вернет пустой массив.
        manager = new MovieManager(3);
        Movie[] movies = manager.findLast();
        Assertions.assertEquals(0, movies.length);
    }

    @Test
    public void testFindLastLessThanLimit() {
        // Тестирование метода  при количестве фильмов меньше лимита. Ожидается, что метод вернет все фильмы в порядке добавления.
        manager = new MovieManager(4);
        Movie movie1 = new Movie("Бладшот", "боевик");
        Movie movie2 = new Movie("Вперёд", "мультфильм");
        manager.add(movie1);
        manager.add(movie2);

        Movie[] movies = manager.findLast();

        Assertions.assertEquals(2, movies.length);
        Assertions.assertEquals(movie2, movies[0]);
        Assertions.assertEquals(movie1, movies[1]);
    }

    @Test
    public void testGetTitleAndGenre() {
        String title = "Бладшот";
        String genre = "боевик";

        Movie movie = new Movie(title, genre);

        Assertions.assertEquals(title, movie.getTitle());
        Assertions.assertEquals(genre, movie.getGenre());
    }

}