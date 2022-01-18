package com.company;

import java.util.List;
import java.util.function.BiPredicate;

public class FindByMap implements FindAble {

    private static final List<Movies> moviesList = JsonIO.getMovies();

    private static final BiPredicate<String, List<Cast>> anonimObject1 = (name, castsCasts) -> {
        List<Cast> collect = castsCasts.stream().filter((cast) -> {
            return cast.getFullName().contains(name);
        }).toList();
        return collect.size() > 0;
    };

    @Override
    public void findMoviesByActor(List<Movies> movies, String nameActor) {

        movies.stream().filter((movies1) -> {
            return movies1.getDirector().getFullName().equals(nameActor);
        }).forEach((movies1) -> {
            System.out.println(movies1.getName());
        });


    }

    @Override
    public void findMoviesByDirector(List<Movies> movies,String nameOfDirector) {
        movies.stream().filter((movies1) -> {
            return movies1.getDirector().getFullName().equals(nameOfDirector);
        }).forEach((movies2) -> {
            System.out.println(movies2.getName());
        });
    }

    @Override
    public void findMoviesByYear(List<Movies> movies, int year) {
        moviesList.stream().filter(movies1 -> movies1.getYear()==year).forEach(movies1 -> System.out.println(movies1.getName()));

    }

    @Override
    public void findMoviesAndRoleByActor(List<Movies>movies,String roleOfActor) {

            movies.stream().filter(kino -> anonimObject1.test(roleOfActor, kino.getCast()))
                    .forEach(kino1 -> System.out.println( kino1.getName()));
        }


    @Override
    public void showActorRoles(List<Movies> movies) {
        moviesList.stream().forEach(Movies::printCast);


    }
}
