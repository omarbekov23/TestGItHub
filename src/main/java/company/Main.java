package company;

import java.util.List;
import java.util.Scanner;

import static company.JsonIO.getMovies;

public class Main {
    private static final List<Movies> movies = getMovies();
    private static final SortAble s = new MovieStore();
    private static final FindAble f = new FindByMap();
    private static final Scanner in = new Scanner(System.in);
    private static final Scanner inForString = new Scanner(System.in);

    public static void main(String[] args) {
        int inputNumber;
        while (true) {
            commads();
            try {
                System.out.print("choose your number: ");
                inputNumber = in.nextInt();

                switch (inputNumber) {
                    case 1 -> {
                        System.out.println("Catalog : ");
                        s.printAllMovies(getMovies());
                    }
                    case 2 -> {
                        System.out.println(" Write the full name of the movie : ");
                        String findMovie = inForString.nextLine();
                        s.findMovie(getMovies(), findMovie);
                    }
                    case 3 -> {
                        System.out.println(" Sorting by years : ");
                        s.sortByYear(getMovies());

                    }
                    case 4 -> {
                        System.out.println("Sorted by movie name:");
                        s.sortByName(movies);
                    }
                    case 5 -> {
                        System.out.println("Directors : ");
                        s.sortByDirector(movies);
                    }
                    case 6 -> {
                        System.out.println("Write actor's name :");
                        String actorName = inForString.nextLine();
                        f.findMoviesByActor(getMovies(), actorName);
                    }
                    case 7 -> {
                        System.out.print(" Write director's name :");
                        String direktorName = inForString.nextLine();
                        f.findMoviesByDirector(getMovies(), direktorName);
                    }
                    case 8 -> f.findMoviesByYear(getMovies(), getInt());

                    case 9 -> {
                        System.out.print("Write roles by actor's name :");
                        String aktorRoles = inForString.nextLine();
                        f.findMoviesAndRoleByActor(getMovies(), aktorRoles);
                    }
                    case 10 -> {
                        System.out.println(" Sorting roles and actors : ");
                        f.showActorRoles(getMovies());
                    }
                    default -> throw new InputException(" You entered a wrong number, please re-enter ");
                }

            } catch (InputException inputException) {
                System.err.println(">>Sorry you didn't choose correctly re-select!<<\n-------------------------------------------------");
            }
        }


    }


    static void commads() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }

    public static int getInt() {
        System.out.print("Write year : ");
        int a = 0;
        try {
            String b = in.next();
            a = Integer.parseInt(b);
        } catch (Exception e) {
            System.out.println("Wrong again, try again");
            e.printStackTrace();
        }
        return a;
    }

}
