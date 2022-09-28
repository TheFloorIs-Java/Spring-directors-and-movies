package App.Service;

import App.Model.Director;
import App.Repository.DirectorRepository;
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
    @Autowired
    public DirectorService(DirectorRepository dr){
        this.dr = dr;
    }
    public List<Director> getAllDirectors(){
        return dr.findAll();
    }
    public Director addDirector(Director d){
        return dr.save(d);
    }
}
