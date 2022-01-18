package com.company;

import java.util.List;

public interface FindAble {

    void findMoviesByActor(List<Movies> movies,String nameActor);

    void findMoviesByDirector(List<Movies> movies,String nameOfDirector);

    void findMoviesByYear(List<Movies> movies, int name);

    void findMoviesAndRoleByActor(List<Movies>movies,String name);

    void showActorRoles(List<Movies> movies);
}
