package App.Service;

import App.Model.Director;
import App.Model.Movie;
import App.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class MovieService {
    MovieRepository mr;
    DirectorService ds;
    @Autowired
    public MovieService(MovieRepository mr, DirectorService ds){
        this.mr = mr;
        this.ds = ds;
    }
    public List<Movie> getAllMovies(){
        return mr.findAll();
    }
    public Movie addMovie(int directorID, Movie m){
        Director d = ds.getDirectorById(directorID);
        m.setDirector(d);
        return mr.save(m);
    }
    public Movie addMovie(Movie m){
        return mr.save(m);
    }
    public Movie getMovieById(int id){
        return mr.findById(id).get();
    }
}
