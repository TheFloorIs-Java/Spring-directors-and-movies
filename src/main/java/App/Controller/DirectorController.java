package App.Controller;

import App.Model.Director;
import App.Service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DirectorController {
    DirectorService ds;
//    dependency injection injects an already-made object for us.
    @Autowired
    public DirectorController(DirectorService ds){
        this.ds = ds;
    }
    @GetMapping("/director")
    public List<Director> getAllDirectors(){
        return ds.getAllDirectors();
    }
    @PostMapping("/director")
    public Director addDirector(@RequestBody Director d){
        return ds.addDirector(d);
    }
    @GetMapping("/director/movie/{id}")
    public Director getDirectorOfMovie(@PathVariable int id){
        return ds.getDirectorOfMovieId(id);
    }
}
