package App.Service;

import App.Model.Director;
import App.Model.Movie;
import App.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
    public Movie getMovieById(int id){
        return mr.findById(id).get();
    }
}
