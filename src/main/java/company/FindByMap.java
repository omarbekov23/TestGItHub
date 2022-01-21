package company;

import java.util.List;
import java.util.function.BiPredicate;


public class FindByMap implements FindAble {

    @Override
    public void findMoviesByActor(List<Movies> movies, String actorName)  {
        movies.stream()
                .filter(kino -> anonimObject1.test(actorName, kino.getCast()))
                .forEach(movies1 -> System.out.println("\u001B[32m" + movies1.getName() + "\u001B[0m"));
    }

    private static final BiPredicate<String, List<Cast>> anonimObject1 = (name, castsCasts) -> {
        List<Cast> collect = castsCasts.stream().filter(cast -> cast.getFullName().contains(name)).toList();
        return collect.size() > 0;
    };

    @Override
    public void findMoviesByDirector(List<Movies> movies, String directorName) {

        movies.stream().filter(movies1 -> movies1.getDirector().getFullName().equals(directorName))
                .forEach(kino -> System.out.println("\u001B[32m" + kino.getName() + "\u001B[0m"));
    }


    @Override
    public void findMoviesByYear(List<Movies> movies, int year) {
        movies.stream().filter(movies1 -> movies1.getYear() == year)
                .forEach(movies1 -> System.out.println("\u001B[32m" + movies1.getName() + "\u001B[0m"));
    }

    @Override
    public void findMoviesAndRoleByActor(List<Movies> movies, String rolAktor) {
        movies.stream().filter(kino -> anonimoject2.test(rolAktor, kino.getCast()))
                .forEach(kino1 -> System.out.println("\u001B[32m" + kino1.getName() + "\u001B[0m"));
    }

    private static final BiPredicate<String, List<Cast>> anonimoject2 = (name, casts) -> {
        List<Cast> castList = casts.stream().filter(cast -> cast.getFullName().contains(name)).toList();
        return castList.size() > 0;
    };

    @Override
    public void showActorRoles(List<Movies> movies) {
        movies.forEach(Movies::printCast);

    }
}
