package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static final List<Movies> movies = JsonIO.getMovies();
    private static SortAble s = (SortAble) new MovieStore();
    private static FindAble f = (FindAble) new FindByMap();
    private static Scanner in = new Scanner(System.in);
    private static Scanner forString = new Scanner(System.in);
//    public static final Path WRITE_PATH= Paths.get("movies.json");



    public static void main(String[] args) throws InputException, IOException {

            while (true) {
                commands();
                int a = in.nextInt();
                switch (a) {
                    case 1 -> {
                        s.printAllMovies(movies);
                    }
                    case 2 -> {
                        System.out.println("Введите название фильма:");
                        String findByName = forString.nextLine();
                        s.findMovie(movies, findByName);
                    }
                    case 3 -> {
                        s.sortByYear(movies);
                    }
                    case 4 -> {
                        s.sortByName(movies);
                    }
                    case 5 -> {
                        s.sortByDirector(movies);
                    }
                    case 6 -> {
                        System.out.println("Введите имя directora:");
                        String nameDir = forString.nextLine();
                        f.findMoviesByActor(movies, nameDir);
                    }
                    case 7 -> {
                        System.out.println("Введите имя режиссера:");
                        String name = forString.nextLine();
                        f.findMoviesByDirector(movies, name);
                    }
                    case 8 -> {
                        f.findMoviesByYear(movies, getInt());
                    }
                    case 9 -> {
                        System.out.println("Введите имя актера: ");
                        String roleOfActor= forString.nextLine();
                        f.findMoviesAndRoleByActor(movies,roleOfActor);
                    }
                    case 10 -> {
                        f.showActorRoles(movies);
                    }default ->
                         throw new InputException ( "Неверная команда");
                }
          }

        }

        static void commands() {
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
        System.out.println("Press 10 show actor roles");
        System.out.println("---------------------------------------------");
    }

    static int getInt() {
        System.out.print("Write year ");
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
