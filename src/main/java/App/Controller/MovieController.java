package App.Controller;

import App.Model.Movie;
import App.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MovieController {
    MovieService ms;
    @Autowired
    public MovieController(MovieService ms){
        this.ms = ms;
    }
    @GetMapping("movies")
    public List<Movie> getAllMovies(){
        return ms.getAllMovies();
    }
    @PostMapping("movies/director/{id}")
    public Movie addMovie(@PathVariable int id, @RequestBody Movie m){
        return ms.addMovie(id, m);
    }
}
