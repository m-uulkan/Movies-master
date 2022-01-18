package com.company;

import java.io.IOException;
import java.util.List;

public interface SortAble {

    void printAllMovies(List<Movies>movies) throws IOException;

    void findMovie(List<Movies> movies,String findBYName);

    void sortByYear(List<Movies> movies);

    void sortByName(List<Movies> movies);

    void sortByDirector(List<Movies> movies);
}
