package App.Repository;

import App.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    /*
    'Movie' and 'year' here comes from my ENTITY, not my table
    :year comes from my @Param
     */
    @Query("from Movie where year = :year")
    public List<Movie> getMovieByYear(@Param("year") int year);
    @Query("from Movie where year = (select max(year) from Movie)")
    public Movie getNewestMovie();
}