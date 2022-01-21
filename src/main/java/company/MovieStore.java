package company;

import java.util.Comparator;
import java.util.List;

public class MovieStore implements SortAble {


    @Override
    public void printAllMovies(List<Movies> movies) {
        JsonIO.getMovies()
                .forEach(movies1 -> System.out.println("\u001B[32m" + movies1+ "\u001B[0m"));
    }

    @Override
    public void findMovie(List<Movies> movies, String findMovie) {
        JsonIO.getMovies().stream()
                .filter(movies1 -> movies1.getName().startsWith(findMovie))
                .forEach(movies1 -> System.out.println("\u001B[32m" + movies1.getName() + "\u001B[0m"));
    }

    @Override
    public void sortByYear(List<Movies> movies) {
        movies.stream().sorted(Comparator.comparing(Movies::getYear))
                .forEach(year -> System.out.println("\u001B[32m \n" + year.getName() + "\u001B[32m \n" + year.getYear() +
                        "\u001B[0m\n------------------------------------------"));
    }

    @Override
    public void sortByName(List<Movies> movies) {
        movies.stream().sorted(Comparator.comparing(Movies::getName))
                .forEach(movies1 -> System.out.println("\u001B[32m" + movies1.getName() + "\u001B[0m"));
    }

    @Override
    public void sortByDirector(List<Movies> movies) {
        movies.stream().sorted(Comparator.comparing(Movies::getName))
                .forEach(movies1 -> System.out.println("\u001B[32m" + movies1.getDirector() + "\u001B[0m"));
    }
}
