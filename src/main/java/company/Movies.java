package company;

import java.util.List;

public class Movies {

    private String name;
    private int year;
    private Director director;
    private List<Cast> cast;

    public Movies(String name, int year, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.cast = cast;
    }

    public void printCast() {
        int counter = 1;
        for (Cast s : cast) {
            System.out.printf("\u001B[32m" + "%s)   Fullname: %s\n", counter, s.getFullName() + "\u001B[0m");
            System.out.println("\u001B[32m" + "     Role: " + s.getRole() + "\u001B[0m");
            counter++;
        }
    }

    public List<Cast> getCast() {
        return cast;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return this.year;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "name:" + "|" + name + " \n " +
                "year:" + "|" + year + "\n" +
                "director:" + "|" + director + "\n" +
                "cast:" + "|" + cast + "\n---------------------------------------------------";
    }
}
