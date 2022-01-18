package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieStore implements SortAble{

       private static final List<Movies> moviesList = JsonIO.getMovies();
    @Override
    public void printAllMovies(List<Movies>movies) {

        moviesList.stream().forEach(System.out::println);


    }

    @Override
    public void findMovie(List<Movies>movies,String findByName) {
        moviesList.stream().filter((movies1 -> movies1.getName().equals(findByName))).forEach(System.out::println);


    }

    @Override
    public void sortByYear(List<Movies> movies) {
      moviesList.stream().sorted(Comparator.comparingInt(Movies::getYear).reversed()).forEach(System.out::println);

    }

    @Override
    public void sortByName(List<Movies> movies) {
       moviesList.stream().sorted(Comparator.comparing(Movies::getName)).forEach(System.out::println);
    }

    @Override
    public void sortByDirector(List<Movies> movies) {
       moviesList.stream().map(Movies::getDirector).sorted(Comparator.comparing(Director::getFullName)).forEach(System.out::println);
    }
}
