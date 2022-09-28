package App.Service;

import App.Model.Director;
import App.Model.Movie;
import App.Repository.DirectorRepository;
import App.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
@Component registers this class as a potential bean, which the spring boot application will find when it does a component scan.
A bean is an object that is managed by the Spring IOC container.
IOC = inversion of control - control over the instantiation of objects has been taken away from the developer and given
to Spring instead. You can think of IOC in general as the developer trusting the framework with control of configuration.
 */
@Component
public class DirectorService {
    DirectorRepository dr;
    MovieRepository mr;
    @Autowired
    public DirectorService(DirectorRepository dr, MovieRepository mr){
        this.dr = dr;
        this.mr = mr;
    }
    public List<Director> getAllDirectors(){
        return dr.findAll();
    }
    public Director getDirectorById(int id){
//        .get should circumvent findById returning an Optional
        return dr.findById(id).get();
    }
    public Director addDirector(Director d){
        return dr.save(d);
    }
    public Director getDirectorOfMovieId(int id){
        Movie m = mr.findById(id).get();
        Director d = m.getDirector();
        return d;
    }
}